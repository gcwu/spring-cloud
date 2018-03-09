package com.common.entity.dto;

import com.common.entity.domain.SysMapUserRole;

import java.util.Date;

import java.io.Serializable;


/**
 * DTO:SysMapUserRoleDTO
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */
public class SysMapUserRoleDTO implements Serializable {

    private Integer    id;
    private String    userId;         /* 用户名id */
    private String    roleId;         /* 角色id */
    private String    createUser;         /* 创建人 */
    private Date    createTime;         /* 创建时间 */
    private String    updateUser;         /* 更新人 */
    private Date    updateTime;         /* 更新时间 */

    // 从 DTO 生成新的数据库模型
    public SysMapUserRole toSysMapUserRoleObject() {
        SysMapUserRole obj = new SysMapUserRole();

        obj.setUserId(userId);
        obj.setRoleId(roleId);
        obj.setCreateUser(createUser);
        obj.setCreateTime(new Date());
        obj.setUpdateUser(updateUser);
        obj.setUpdateTime(updateTime);

        return obj;
    }

    // 从 DTO 更新数据库模型
    public void mergeUpdate(SysMapUserRole obj) {
        obj.setUserId(userId);
        obj.setRoleId(roleId);
        obj.setCreateUser(createUser);
        obj.setUpdateUser(updateUser);
        obj.setUpdateTime(updateTime);
    }

    // 从据库模型生成 DTO
    public SysMapUserRoleDTO(SysMapUserRole obj) {
        id = obj.getId();
        userId = obj.getUserId();
        roleId = obj.getRoleId();
        createUser = obj.getCreateUser();
        createTime = obj.getCreateTime();
        updateUser = obj.getUpdateUser();
        updateTime = obj.getUpdateTime();
    }

    // 默认 constructor
    public SysMapUserRoleDTO() {
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
