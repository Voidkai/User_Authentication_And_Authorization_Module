package corp.sap.internal.exp.authentication;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import corp.sap.internal.exp.config.JsonResult;
import corp.sap.internal.exp.config.ResultTool;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        JsonResult result = ResultTool.success();
        httpServletResponse.setContentType("text/json;charset=utf-8");

        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
