package com.system.mapper;


import com.common.base.mapper.BaseMapper;
import com.common.entity.domain.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Dao Interface:SysMenuMapper
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
	/**
	 * 根据用户id获取当前用所拥有的所有菜单栏
	 * @param userId
	 * @return
	 */
	List<SysMenu> fetchUserMenu(@Param("userId")String userId);
	/**
	 * 根据角色id获取当前用所拥有的所有菜单栏
	 * @param roleId
	 * @return
	 */
	List<SysMenu> fetchRoleMenu(@Param("roleId")String roleId);
}
