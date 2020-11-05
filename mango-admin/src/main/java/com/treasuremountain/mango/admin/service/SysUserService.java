package com.treasuremountain.mango.admin.service;

import com.treasuremountain.mango.admin.model.SysUser;

import java.util.List;

public interface SysUserService {

    /**
     * 查找所有用户
     * @return
     */
    List<SysUser> findAll();

    /**
     * 通过id查询
     * @param id
     * @return
     */
    SysUser findById(Long id);

}
