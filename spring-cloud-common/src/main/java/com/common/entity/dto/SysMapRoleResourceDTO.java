package com.common.entity.dto;

import com.common.entity.domain.SysMapRoleResource;

import java.util.Date;

import java.io.Serializable;


/**
 * DTO:SysMapRoleResourceDTO
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */
public class SysMapRoleResourceDTO implements Serializable {

    private Integer    id;
    private String    roleId;         /* 角色编码 */
    private String    resourceId;         /* 菜单或资源编码  */
    private String    resourceType;         /* 类型；1-菜单，2-资源  */
    private String    crateUser;         /* 创建人 */
    private Date    createTime;         /* 创建时间  */
    private String    updateUser;         /* 更新人 */
    private Date    updateTime;         /* 更新时间 */

    // 从 DTO 生成新的数据库模型
    public SysMapRoleResource toSysMapRoleResourceObject() {
        SysMapRoleResource obj = new SysMapRoleResource();

        obj.setRoleId(roleId);
        obj.setResourceId(resourceId);
        obj.setResourceType(resourceType);
        obj.setCrateUser(crateUser);
        obj.setCreateTime(new Date());
        obj.setUpdateUser(updateUser);
        obj.setUpdateTime(updateTime);

        return obj;
    }

    // 从 DTO 更新数据库模型
    public void mergeUpdate(SysMapRoleResource obj) {
        obj.setRoleId(roleId);
        obj.setResourceId(resourceId);
        obj.setResourceType(resourceType);
        obj.setCrateUser(crateUser);
        obj.setUpdateUser(updateUser);
        obj.setUpdateTime(updateTime);
    }

    // 从据库模型生成 DTO
    public SysMapRoleResourceDTO(SysMapRoleResource obj) {
        id = obj.getId();
        roleId = obj.getRoleId();
        resourceId = obj.getResourceId();
        resourceType = obj.getResourceType();
        crateUser = obj.getCrateUser();
        createTime = obj.getCreateTime();
        updateUser = obj.getUpdateUser();
        updateTime = obj.getUpdateTime();
    }

    // 默认 constructor
    public SysMapRoleResourceDTO() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getRoleId() {
        return roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
    public String getResourceId() {
        return resourceId;
    }
    
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
    
    public String getResourceType() {
        return resourceType;
    }
    
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
    
    public String getCrateUser() {
        return crateUser;
    }
    
    public void setCrateUser(String crateUser) {
        this.crateUser = crateUser;
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
