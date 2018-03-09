package com.test.cloud.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

//    @Autowired
//    UserDao userDao;
//    @Autowired
//    PermissionDao permissionDao;

    public UserDetails loadUserByUsername(String username) {
//        SysUser user = userDao.findByUserName(username);
//        if (user != null) {
//            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//            for (Permission permission : permissions) {
//                if (permission != null && permission.getName()!=null) {
//
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_AUTH");
//                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
//                }
//            }
        return new User("admin", "admin", grantedAuthorities);
    }
}

