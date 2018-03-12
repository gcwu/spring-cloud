package com.system.controller;

import com.common.base.web.BaseController;

import com.common.entity.domain.SysMapUserRole;
import com.common.util.Page;

import com.system.service.SysMapUserRoleService;
import io.swagger.annotations.Api;
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
 * 用户和角色关联的RestController
 */
@Api(value = "SysMapUserRoleController", description = "角色和资源信息关联的RestController")
@RestController
public class SysMapUserRoleController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SysMapUserRoleController.class);
    
    @Resource
    private SysMapUserRoleService sysMapUserRoleService;
    
    /**
     * 根据id查询用户信息和资源关联的数据
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysMapUserRole/getId/{id}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getId(@PathVariable String id, HttpServletRequest request) {
        return sysMapUserRoleService.get(id);
    }
    
    /**
     * 分页查询
     * @param
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysMapUserRole/pageList", method = RequestMethod.POST)
    public Object pageList(final SysMapUserRole model, HttpServletRequest request, final Integer page, final Integer pageSize) {
        //加入分页的page和pageSize属性，可以直接在前端设定
        if(model.getPage()==null){
            model.setPage(new Page<SysMapUserRole>());
            model.getPage().setPage(page);
            model.getPage().setPageSize(pageSize);
            //可以加入排序的方法
//        model.getPage().setSort("public_time");
//        model.getPage().setOrder(Constant.DESC);
        }
        return sysMapUserRoleService.findPage(model);
    }
	
	/**
	 * 修改信息
     * @param model
	 * @param request
	 * @return
	 */
    @RequestMapping(value = "/sysMapUserRole/update",method = RequestMethod.POST )
    public Object update(final SysMapUserRole model, HttpServletRequest request) {
	    sysMapUserRoleService.update(model);
        return renderSuccessResult();
    }
    /**
     * 删除对应id的数据
     * @param id
     * @param requestt
     * @return
     */
    @RequestMapping(value = "/sysMapUserRole/del/{id}",method = RequestMethod.GET )
    public Object del(@PathVariable String id, HttpServletRequest requestt) {
	    sysMapUserRoleService.delete(id);
        return renderSuccessResult();
    }
	
	/**
	 * 新增信息
     * @param model
	 * @param request
	 * @return
	 */
    @RequestMapping(value = "/sysMapUserRole/insert",method = RequestMethod.POST )
    public Object insert(final SysMapUserRole model, HttpServletRequest request) {
	    sysMapUserRoleService.insert(model);
        return renderSuccessResult();
    }
}

