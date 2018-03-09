package com.test.cloud.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class MyInvocationSecurityMetadaSource
        implements FilterInvocationSecurityMetadataSource {
    private static Map<String,Collection<ConfigAttribute>> resourceMap = null;

    public MyInvocationSecurityMetadaSource(){
        loadResourceDefine();
    }

    private void loadResourceDefine(){
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        //默认加载所有资源都为用户权限
        ConfigAttribute ca = new SecurityConfig("ROLE_AUTH");
        atts.add(ca);
//        resourceMap.put("/user.jsp", atts);
//        resourceMap.put("/admin.jsp", atts);
//        resourceMap.put("/index.jsp",atts);
//        resourceMap.put("/auth/login", atts);
//        resourceMap.put("/auth/logout", atts);
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {

        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        //默认只要登录都拥有用户权限
        ConfigAttribute ca = new SecurityConfig("ROLE_AUTH");
        atts.add(ca);
//        String url = ((FilterInvocation)object).getRequestUrl();
//        Iterator<String> ite = resourceMap.keySet().iterator();
//
//        while(ite.hasNext()){
//            String resURL = ite.next();
//
//            if(url.equalsIgnoreCase(resURL)){
//                return resourceMap.get(resURL);
//            }
//
//        }
        return atts;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }


}
