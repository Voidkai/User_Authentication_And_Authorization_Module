package corp.sap.internal.exp.config.handler;

import corp.sap.internal.exp.DTO.ResponseWrapper;
import corp.sap.internal.exp.utils.ProcessingStatusCode;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //返回json数据
        ResponseWrapper result = null;
        if (e instanceof AccountExpiredException) {
            //账号过期
            result = ResponseWrapper.fail(ProcessingStatusCode.USER_ACCOUNT_EXPIRED);
        } else if (e instanceof BadCredentialsException) {
            //密码错误
            result = ResponseWrapper.fail(ProcessingStatusCode.USER_CREDENTIALS_ERROR);
        } else if (e instanceof CredentialsExpiredException) {
            //密码过期
            result = ResponseWrapper.fail(ProcessingStatusCode.USER_CREDENTIALS_EXPIRED);
        } else if (e instanceof DisabledException) {
            //账号不可用
            result = ResponseWrapper.fail(ProcessingStatusCode.USER_ACCOUNT_DISABLE);
        } else if (e instanceof LockedException) {
            //账号锁定
            result = ResponseWrapper.fail(ProcessingStatusCode.USER_ACCOUNT_LOCKED);
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            result = ResponseWrapper.fail(ProcessingStatusCode.USER_ACCOUNT_NOT_EXIST);
        } else {
            //其他错误
            result = ResponseWrapper.fail(ProcessingStatusCode.COMMON_FAIL);
        }
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(result.toString());
    }
}