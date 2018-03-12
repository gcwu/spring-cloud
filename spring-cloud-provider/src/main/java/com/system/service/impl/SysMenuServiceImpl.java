package com.system.service.impl;


import com.common.base.service.BaseServiceImpl;
import com.common.entity.domain.SysMenu;
import com.common.entity.dto.SysMenuDTO;
import com.system.mapper.SysMenuMapper;
import com.system.service.SysMenuService;
import com.system.util.SysMenuUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * ServiceImpl:SysMenuServiceImpl
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;
	
	@Override
	public List<SysMenuDTO> fetchUserMenu(String userId) {
		List<SysMenu>list=sysMenuMapper.fetchUserMenu(userId);
		return SysMenuUtils.sysMenuUtils(list);
	}
	
	@Override
	public List<SysMenuDTO> fetchRoleMenu(String roleId) {
		 List<SysMenu>list =sysMenuMapper.fetchRoleMenu(roleId);
		return SysMenuUtils.sysMenuUtils(list);
	}
	
	
	
}
