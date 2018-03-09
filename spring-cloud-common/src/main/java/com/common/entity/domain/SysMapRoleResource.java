package com.common.entity.domain;

import java.util.Date;

import com.common.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * entity:SysMapRoleResource
 *
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */

public class SysMapRoleResource extends BaseEntity<SysMapRoleResource> {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Integer id;
    
    /**
     * 角色编码
     */
    private String roleId;
    
    /**
     * 菜单或资源编码
     */
    private String resourceId;
    
    /**
     * 类型；1-菜单，2-资源
     */
    private String resourceType;
    
    /**
     * 创建人
     */
    private String crateUser;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新人
     */
    private String updateUser;
    
    /**
     * 更新时间
     */
    private Date updateTime;

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
