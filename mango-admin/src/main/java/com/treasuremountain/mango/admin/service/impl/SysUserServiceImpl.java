package com.treasuremountain.mango.admin.service.impl;

import com.treasuremountain.mango.admin.dao.SysUserMapper;
import com.treasuremountain.mango.admin.model.SysUser;
import com.treasuremountain.mango.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }

    @Override
    public SysUser findById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }


}
