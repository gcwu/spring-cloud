package com.common.entity.domain;

import java.util.Date;

import com.common.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * entity:SysUser
 *
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */
public class SysUser extends BaseEntity<SysUser> {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String loginName;  /* 用户名 */
    private String password;  /* 登录密码 */
    private String userType;  /* 用户类型; 1-系统管理员，2-普通用户 */
    private String status;  /* 状态  0-冻结 1-正常 */
    private Date lastLoginTime;  /* 最后一次登录时间 */
    private String createUser;  /* 创建人 */
    private Date createTime;  /* 创建时间 */
    private String updateUser;  /* 更新人 */
    private Date updateTime;  /* 更新时间 */

    //其他自定义属性
    @JsonIgnore
    public String getUuid() {
        return super.getUuid();
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
