package com.test.cloud.security;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录失败处理
 * @author Wu
 *
 */
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    private Logger logger = LoggerFactory.getLogger(AuthenticationFailureHandlerImpl.class);
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        Map<String,String> map = new HashMap<>();
        String message = "";
        if(StringUtils.isNotBlank(exception.getMessage())) {
            message = exception.getMessage();
        }
        logger.error("登录失败---"+message);
        map.put("code","0001");
        map.put("msg","用户名或者密码错误");
        //将实体对象转换为JSON Object转换
        String responseJSONObject = JSONObject.toJSONString(map);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(responseJSONObject);
            logger.debug("=====>返回是"+responseJSONObject);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }
}

