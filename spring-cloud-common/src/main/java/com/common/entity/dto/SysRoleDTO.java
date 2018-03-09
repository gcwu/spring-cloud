package com.common.entity.dto;

import com.common.entity.domain.SysRole;

import java.util.Date;

import java.io.Serializable;


/**
 * DTO:SysRoleDTO
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */
public class SysRoleDTO implements Serializable {

    private Integer    id;
    private String    code;         /* 角色编码 */
    private String    name;         /* 角色名 */
    private String    status;         /* 状态  0-冻结 1-正常 */
    private String    description;         /* 描述 */
    private String    createUser;         /* 创建人 */
    private Date    createTime;         /* 创建时间 */
    private String    updateUser;         /* 更新人 */
    private Date    updateTime;         /* 更新时间 */

    // 从 DTO 生成新的数据库模型
    public SysRole toSysRoleObject() {
        SysRole obj = new SysRole();

        obj.setCode(code);
        obj.setName(name);
        obj.setStatus(status);
        obj.setDescription(description);
        obj.setCreateUser(createUser);
        obj.setCreateTime(new Date());
        obj.setUpdateUser(updateUser);
        obj.setUpdateTime(updateTime);

        return obj;
    }

    // 从 DTO 更新数据库模型
    public void mergeUpdate(SysRole obj) {
        obj.setCode(code);
        obj.setName(name);
        obj.setStatus(status);
        obj.setDescription(description);
        obj.setCreateUser(createUser);
        obj.setUpdateUser(updateUser);
        obj.setUpdateTime(updateTime);
    }

    // 从据库模型生成 DTO
    public SysRoleDTO(SysRole obj) {
        id = obj.getId();
        code = obj.getCode();
        name = obj.getName();
        status = obj.getStatus();
        description = obj.getDescription();
        createUser = obj.getCreateUser();
        createTime = obj.getCreateTime();
        updateUser = obj.getUpdateUser();
        updateTime = obj.getUpdateTime();
    }

    // 默认 constructor
    public SysRoleDTO() {
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
