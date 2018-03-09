package com.common.entity.domain;

import java.util.Date;

import com.common.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * entity:SysRole
 *
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */
public class SysRole extends BaseEntity<SysRole> {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String code;  /* 角色编码 */
    private String name;  /* 角色名 */
    private String status;  /* 状态  0-冻结 1-正常 */
    private String description;  /* 描述 */
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
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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
