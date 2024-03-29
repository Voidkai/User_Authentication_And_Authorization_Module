package corp.sap.internal.exp.service.Impl;

import corp.sap.internal.exp.dao.PrivilegeDao;
import corp.sap.internal.exp.domain.Privilege;
import corp.sap.internal.exp.service.PrivilegeChallenge;
import corp.sap.internal.exp.service.PrivilegeCheckService;
import corp.sap.internal.exp.service.exceptions.NotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Profile({"rbac-basic-cache"})
public class RBACPrivilegeCheckServiceWithCacheImpl implements PrivilegeCheckService {

    @Autowired
    private PrivilegeDao privilegeDao;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public Boolean check(PrivilegeChallenge privilegeChallenge) throws NotSupportedException {
        if (privilegeChallenge instanceof RBACPrivilegeChallenge) {
            RBACPrivilegeChallenge rbacPrivilegeChallenge = (RBACPrivilegeChallenge) privilegeChallenge;
            Integer userId = rbacPrivilegeChallenge.getUserId();
            String privCode = rbacPrivilegeChallenge.getPrivilegeCode();
            String key = userId + "_" + privCode;
            ValueOperations<String, Boolean> operations = redisTemplate.opsForValue();
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                return operations.get(key);
            } else {

                List<Privilege> permList = privilegeDao.getPrivByUserId(rbacPrivilegeChallenge.getUserId());
                List<String> codeList = new ArrayList<>();
                for (Privilege perm : permList) codeList.add(perm.getCode());

                for (String code : codeList) {
                    if (code.equals(rbacPrivilegeChallenge.getPrivilegeCode())) {
                        operations.set(key, true, 5, TimeUnit.HOURS);
                        return true;
                    } else {
                        operations.set(key, false, 5, TimeUnit.HOURS);
                    }
                }
            }
        } else {
            throw new NotSupportedException("");
        }

        return false;
    }
}
