package com.system.controller;

import com.common.base.web.BaseController;

import com.common.entity.domain.SysUser;
import com.common.util.Page;

import com.system.service.SysUserService;
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
public class SysUserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
    
    @Resource
    private SysUserService sysUserService;
    
    /**
     * 根据id查询用户信息和资源关联的数据
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysUser/getId/{id}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getId(@PathVariable String id, HttpServletRequest request) {
        return sysUserService.get(id);
    }
    
    /**
     * 分页查询
     * @param
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysUser/pageList", method = RequestMethod.POST)
    public Object pageList(final SysUser model, HttpServletRequest request, final Integer page, final Integer pageSize) {
        //加入分页的page和pageSize属性，可以直接在前端设定
        if(model.getPage()==null){
            model.setPage(new Page<SysUser>());
            model.getPage().setPage(page);
            model.getPage().setPageSize(pageSize);
            //可以加入排序的方法
//        model.getPage().setSort("public_time");
//        model.getPage().setOrder(Constant.DESC);
        }
        return sysUserService.findPage(model);
    }
	
	/**
	 * 修改信息
     * @param model
	 * @param request
	 * @return
	 */
    @RequestMapping(value = "/sysUser/update",method = RequestMethod.POST )
    public Object update(final SysUser model, HttpServletRequest request) {
	    sysUserService.update(model);
        return renderSuccessResult();
    }
    /**
     * 删除对应id的数据
     * @param id
     * @param requestt
     * @return
     */
    @RequestMapping(value = "/sysUser/del/{id}",method = RequestMethod.GET )
    public Object del(@PathVariable String id, HttpServletRequest requestt) {
	    sysUserService.delete(id);
        return renderSuccessResult();
    }
	
	/**
	 * 新增信息
     * @param model
	 * @param request
	 * @return
	 */
    @RequestMapping(value = "/sysUser/insert",method = RequestMethod.POST )
    public Object insert(final SysUser model, HttpServletRequest request) {
	    sysUserService.insert(model);
        return renderSuccessResult();
    }
}

