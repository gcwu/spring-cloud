package com.system.service;


import com.common.base.service.BaseService;
import com.common.entity.domain.SysMenu;
import com.common.entity.dto.SysMenuDTO;


import java.util.List;

/**
 * Service Interface:SysMenuService
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */
public interface SysMenuService extends BaseService<SysMenu> {
	/**
	 * 根据用户id获取当前用所拥有的所有菜单栏
	 * @param userId
	 * @return
	 */
	List<SysMenuDTO> fetchUserMenu(String userId);
	/**
	 * 根据角色id获取当前用所拥有的所有菜单栏
	 * @param roleId
	 * @return
	 */
	List<SysMenuDTO> fetchRoleMenu(String roleId);
}
