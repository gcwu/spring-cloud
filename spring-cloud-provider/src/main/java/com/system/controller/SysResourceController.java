package com.system.controller;

import com.common.base.web.BaseController;

import com.common.entity.domain.SysResource;
import com.common.util.Page;

import com.system.service.SysResourceService;
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
public class SysResourceController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SysResourceController.class);
    
    @Resource
    private SysResourceService sysResourceService;
    
    /**
     * 根据id查询用户信息和资源关联的数据
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysResource/getId/{id}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getId(@PathVariable String id, HttpServletRequest request) {
        return sysResourceService.get(id);
    }
    
    /**
     * 分页查询
     * @param
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysResource/pageList", method = RequestMethod.POST)
    public Object pageList(final SysResource model, HttpServletRequest request, final Integer page, final Integer pageSize) {
        //加入分页的page和pageSize属性，可以直接在前端设定
        if(model.getPage()==null){
            model.setPage(new Page<SysResource>());
            model.getPage().setPage(page);
            model.getPage().setPageSize(pageSize);
            //可以加入排序的方法
//        model.getPage().setSort("public_time");
//        model.getPage().setOrder(Constant.DESC);
        }
        return sysResourceService.findPage(model);
    }
	
	/**
	 * 修改信息
     * @param model
	 * @param request
	 * @return
	 */
    @RequestMapping(value = "/sysResource/update",method = RequestMethod.POST )
    public Object update(final SysResource model, HttpServletRequest request) {
	    sysResourceService.update(model);
        return renderSuccessResult();
    }
    /**
     * 删除对应id的数据
     * @param id
     * @param requestt
     * @return
     */
    @RequestMapping(value = "/sysResource/del/{id}",method = RequestMethod.GET )
    public Object del(@PathVariable String id, HttpServletRequest requestt) {
	    sysResourceService.delete(id);
        return renderSuccessResult();
    }
	
	/**
	 * 新增信息
     * @param model
	 * @param request
	 * @return
	 */
    @RequestMapping(value = "/sysResource/insert",method = RequestMethod.POST )
    public Object insert(final SysResource model, HttpServletRequest request) {
	    sysResourceService.insert(model);
        return renderSuccessResult();
    }
}

