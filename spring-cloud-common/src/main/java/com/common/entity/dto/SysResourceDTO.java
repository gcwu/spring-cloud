package com.common.entity.dto;

import com.common.entity.domain.SysResource;

import java.util.Date;

import java.io.Serializable;


/**
 * DTO:SysResourceDTO
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */
public class SysResourceDTO implements Serializable {

    private Integer    id;         /* 资源主键  */
    private Integer    menuId;         /* 菜单主键  */
    private String    code;         /* 资源编码  */
    private String    name;         /* 资源名称  */
    private String    url;         /* 资源路径  */
    private Integer    type;         /* 类型；1-菜单，2-资源 */
    private String    stauts;         /* 状态;1-有效，0-无效 */
    private String    description;         /* 描述  */
    private String    createUser;         /* 创建人 */
    private Date    createTime;         /* 创建时间  */
    private String    updateUser;         /* 更新人 */
    private Date    updateTime;         /* 更新时间 */

    // 从 DTO 生成新的数据库模型
    public SysResource toSysResourceObject() {
        SysResource obj = new SysResource();

        obj.setMenuId(menuId);
        obj.setCode(code);
        obj.setName(name);
        obj.setUrl(url);
        obj.setType(type);
        obj.setStauts(stauts);
        obj.setDescription(description);
        obj.setCreateUser(createUser);
        obj.setCreateTime(new Date());
        obj.setUpdateUser(updateUser);
        obj.setUpdateTime(updateTime);

        return obj;
    }

    // 从 DTO 更新数据库模型
    public void mergeUpdate(SysResource obj) {
        obj.setMenuId(menuId);
        obj.setCode(code);
        obj.setName(name);
        obj.setUrl(url);
        obj.setType(type);
        obj.setStauts(stauts);
        obj.setDescription(description);
        obj.setCreateUser(createUser);
        obj.setUpdateUser(updateUser);
        obj.setUpdateTime(updateTime);
    }

    // 从据库模型生成 DTO
    public SysResourceDTO(SysResource obj) {
        id = obj.getId();
        menuId = obj.getMenuId();
        code = obj.getCode();
        name = obj.getName();
        url = obj.getUrl();
        type = obj.getType();
        stauts = obj.getStauts();
        description = obj.getDescription();
        createUser = obj.getCreateUser();
        createTime = obj.getCreateTime();
        updateUser = obj.getUpdateUser();
        updateTime = obj.getUpdateTime();
    }

    // 默认 constructor
    public SysResourceDTO() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getMenuId() {
        return menuId;
    }
    
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
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
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public Integer getType() {
        return type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    public String getStauts() {
        return stauts;
    }
    
    public void setStauts(String stauts) {
        this.stauts = stauts;
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
