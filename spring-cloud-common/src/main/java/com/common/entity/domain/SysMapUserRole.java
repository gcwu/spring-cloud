package com.common.entity.domain;

import java.util.Date;

import com.common.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * entity:SysMapUserRole
 *
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */

public class SysMapUserRole extends BaseEntity<SysMapUserRole> {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String userId;  /* 用户名id */
    private String roleId;  /* 角色id */
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
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getRoleId() {
        return roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
