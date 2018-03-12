package com.common.entity.dto;

import com.common.entity.domain.SysMenu;

import java.util.Date;

import java.io.Serializable;
import java.util.List;


/**
 * DTO:SysMenuDTO
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */

public class SysMenuDTO implements Serializable {

    private Integer    id;
    private String    code;         /* 菜单编码 */
    private String    name;         /* 菜单名称 */
    private String    url;         /* 菜单请求路径 */
    private Integer    parentId;         /* 父菜单主键 */
    private Integer    level;         /* 菜单级别 */
    private Integer    seq;         /* 顺序号 */
    private String    status;         /* 状态;1-有效，0-无效 */
    private String    remark;         /* 描述  */
    private String    createUser;         /* 创建人  */
    private Date    createTime;         /* 创建时间  */
    private String    updeteUser;         /* 更新人 */
    private Date    updateTime;         /* 更新时间 */
    private List<SysMenu> childrenTree;      //获取子目录
    // 从 DTO 生成新的数据库模型
    public SysMenu toSysMenuObject() {
        SysMenu obj = new SysMenu();

        obj.setCode(code);
        obj.setName(name);
        obj.setUrl(url);
        obj.setParentId(parentId);
        obj.setLevel(level);
        obj.setSeq(seq);
        obj.setStatus(status);
        obj.setRemark(remark);
        obj.setCreateUser(createUser);
        obj.setCreateTime(new Date());
        obj.setUpdeteUser(updeteUser);
        obj.setUpdateTime(updateTime);

        return obj;
    }

    // 从 DTO 更新数据库模型
    public void mergeUpdate(SysMenu obj) {
        obj.setCode(code);
        obj.setName(name);
        obj.setUrl(url);
        obj.setParentId(parentId);
        obj.setLevel(level);
        obj.setSeq(seq);
        obj.setStatus(status);
        obj.setRemark(remark);
        obj.setCreateUser(createUser);
        obj.setUpdeteUser(updeteUser);
        obj.setUpdateTime(updateTime);
    }

    // 从据库模型生成 DTO
    public SysMenuDTO(SysMenu obj) {
        id = obj.getId();
        code = obj.getCode();
        name = obj.getName();
        url = obj.getUrl();
        parentId = obj.getParentId();
        level = obj.getLevel();
        seq = obj.getSeq();
        status = obj.getStatus();
        remark = obj.getRemark();
        createUser = obj.getCreateUser();
        createTime = obj.getCreateTime();
        updeteUser = obj.getUpdeteUser();
        updateTime = obj.getUpdateTime();
    }

    // 默认 constructor
    public SysMenuDTO() {
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
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public Integer getParentId() {
        return parentId;
    }
    
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
    public Integer getLevel() {
        return level;
    }
    
    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public Integer getSeq() {
        return seq;
    }
    
    public void setSeq(Integer seq) {
        this.seq = seq;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
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
    
    public String getUpdeteUser() {
        return updeteUser;
    }
    
    public void setUpdeteUser(String updeteUser) {
        this.updeteUser = updeteUser;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public List<SysMenu> getChildrenTree() {
        return childrenTree;
    }
    
    public void setChildrenTree(List<SysMenu> childrenTree) {
        this.childrenTree = childrenTree;
    }
}
