package com.system.controller;

import com.common.base.web.BaseController;

import com.common.entity.domain.SysRole;
import com.common.util.Page;

import com.system.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * 角色和资源信息关联的RestController
 */
@RestController
public class SysRoleController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SysRoleController.class);
    
    @Resource
    private SysRoleService sysRoleService;
    
    /**
     * 根据id查询用户信息和资源关联的数据
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysRole/getId/{id}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getId(@PathVariable String id, HttpServletRequest request) {
        return sysRoleService.get(id);
    }
    
    /**
     * 分页查询
     * @param
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysRole/pageList", method = RequestMethod.POST)
    public Object pageList(final SysRole model, HttpServletRequest request, final Integer page, final Integer pageSize) {
        //加入分页的page和pageSize属性，可以直接在前端设定
        if(model.getPage()==null){
            model.setPage(new Page<SysRole>());
            model.getPage().setPage(page);
            model.getPage().setPageSize(pageSize);
            //可以加入排序的方法
//        model.getPage().setSort("public_time");
//        model.getPage().setOrder(Constant.DESC);
        }
        return sysRoleService.findPage(model);
    }
	
	/**
	 * 修改信息
     * @param model
	 * @param request
	 * @return
	 */
    @RequestMapping(value = "/sysRole/update",method = RequestMethod.POST )
    public Object update(final SysRole model, HttpServletRequest request) {
	    sysRoleService.update(model);
        return renderSuccessResult();
    }
    /**
     * 删除对应id的数据
     * @param id
     * @param requestt
     * @return
     */
    @RequestMapping(value = "/sysRole/del/{id}",method = RequestMethod.GET )
    public Object del(@PathVariable String id, HttpServletRequest requestt) {
	    sysRoleService.delete(id);
        return renderSuccessResult();
    }
	
	/**
	 * 新增信息
     * @param model
	 * @param request
	 * @return
	 */
    @RequestMapping(value = "/sysRole/insert",method = RequestMethod.POST )
    public Object insert(final SysRole model, HttpServletRequest request) {
	    sysRoleService.insert(model);
        return renderSuccessResult();
    }
}

