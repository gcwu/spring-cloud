package com.common.entity.dto;

import com.common.entity.domain.SysUser;

import java.util.Date;

import java.io.Serializable;


/**
 * DTO:SysUserDTO
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */
public class SysUserDTO implements Serializable {

    private Integer    id;
    private String    loginName;         /* 用户名 */
    private String    password;         /* 登录密码 */
    private String    userType;         /* 用户类型; 1-系统管理员，2-普通用户 */
    private String    status;         /* 状态  0-冻结 1-正常 */
    private Date    lastLoginTime;         /* 最后一次登录时间 */
    private String    createUser;         /* 创建人 */
    private Date    createTime;         /* 创建时间 */
    private String    updateUser;         /* 更新人 */
    private Date    updateTime;         /* 更新时间 */

    // 从 DTO 生成新的数据库模型
    public SysUser toSysUserObject() {
        SysUser obj = new SysUser();

        obj.setLoginName(loginName);
        obj.setPassword(password);
        obj.setUserType(userType);
        obj.setStatus(status);
        obj.setLastLoginTime(lastLoginTime);
        obj.setCreateUser(createUser);
        obj.setCreateTime(new Date());
        obj.setUpdateUser(updateUser);
        obj.setUpdateTime(updateTime);

        return obj;
    }

    // 从 DTO 更新数据库模型
    public void mergeUpdate(SysUser obj) {
        obj.setLoginName(loginName);
        obj.setPassword(password);
        obj.setUserType(userType);
        obj.setStatus(status);
        obj.setLastLoginTime(lastLoginTime);
        obj.setCreateUser(createUser);
        obj.setUpdateUser(updateUser);
        obj.setUpdateTime(updateTime);
    }

    // 从据库模型生成 DTO
    public SysUserDTO(SysUser obj) {
        id = obj.getId();
        loginName = obj.getLoginName();
        password = obj.getPassword();
        userType = obj.getUserType();
        status = obj.getStatus();
        lastLoginTime = obj.getLastLoginTime();
        createUser = obj.getCreateUser();
        createTime = obj.getCreateTime();
        updateUser = obj.getUpdateUser();
        updateTime = obj.getUpdateTime();
    }

    // 默认 constructor
    public SysUserDTO() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getLoginName() {
        return loginName;
    }
    
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUserType() {
        return userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    public String getCreateUser() {
        return createUser;
    }
    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getUpdateUser() {
        return updateUser;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
