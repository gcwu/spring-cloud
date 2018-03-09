package com.common.entity.domain;

import java.util.Date;

import com.common.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * entity:SysResource
 *
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */

public class SysResource extends BaseEntity<SysResource> {
    private static final long serialVersionUID = 1L;

    private Integer id;  /* 资源主键  */
    private Integer menuId;  /* 菜单主键  */
    private String code;  /* 资源编码  */
    private String name;  /* 资源名称  */
    private String url;  /* 资源路径  */
    private Integer type;  /* 类型；1-菜单，2-资源 */
    private String stauts;  /* 状态;1-有效，0-无效 */
    private String description;  /* 描述  */
    private String createUser;  /* 创建人 */
    private Date createTime;  /* 创建时间  */
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
