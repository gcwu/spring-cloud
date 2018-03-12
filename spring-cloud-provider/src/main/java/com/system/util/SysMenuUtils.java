package com.system.util;

import com.common.entity.domain.SysMenu;
import com.common.entity.dto.SysMenuDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单的帮助类
 *
 */
public class SysMenuUtils {
	/**
	 * 获取菜单的帮助类
	 * @param list
	 * @return
	 */
  public  static List<SysMenuDTO> sysMenuUtils(List<SysMenu> list){
	  List<SysMenuDTO> sysMenuDTOlist=new ArrayList<SysMenuDTO>();
	  //循环遍历为一级菜单的目录
	  if(list!=null&& list.size()>0) {
		  list.stream().filter(page -> page != null).forEach(page -> {
			  if (page.getLevel() == 1) {
				  SysMenuDTO dto = new SysMenuDTO();
				  dto.setCode(page.getCode());
				  dto.setCreateTime(page.getCreateTime());
				  dto.setCreateUser(page.getCreateUser());
				  dto.setId(page.getId());
				  dto.setName(page.getName());
				  dto.setLevel(page.getLevel());
				  dto.setParentId(page.getParentId());
				  dto.setRemark(page.getRemark());
				  dto.setSeq(page.getSeq());
				  dto.setStatus(page.getStatus());
				  dto.setUpdateTime(page.getUpdateTime());
				  dto.setUrl(page.getUrl());
				  sysMenuDTOlist.add(dto);
			  }
			
		  });
		  //把2级菜单加入到以一级菜单的子目录
		  if (sysMenuDTOlist.size()>0){
			  list.stream().filter(page -> page != null).forEach(page -> {
				  sysMenuDTOlist.stream().filter(item -> item != null).forEach(item -> {
					  if (item != null && item.getId() == page.getParentId()) {
					  	    if(item.getChildrenTree()==null){
						        item.setChildrenTree(new ArrayList<SysMenu>());
					        }
						  item.getChildrenTree().add(page);
					  }
				  });
			  });
	  }
	  }
	  
  	    return  sysMenuDTOlist;
  }
}
