package com.system.service.impl;



import com.common.base.service.BaseServiceImpl;
import com.common.entity.domain.SysUser;
import com.system.mapper.SysUserMapper;
import com.system.service.SysUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * ServiceImpl:SysUserServiceImpl
 * @author philip@xinzhentech.com
 * @version 1.0
 * @date 2018-3-8
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    //@Resource
    //private SysUserMapper sysUserMapper;

}
