package corp.sap.internal.exp.service;

import corp.sap.internal.exp.dao.PrivilegeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PrivilegeService {
    @Autowired
    PrivilegeDao privilegeDao;


    public List<Map<String,Object>> getprivByUser(Integer id){
        return privilegeDao.getprivByUser(id);
    }

}