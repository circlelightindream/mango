package com.treasuremountain.mango.admin.service;

import com.treasuremountain.mango.admin.model.SysUser;
import com.treasuremountain.mango.admin.model.SysUserRole;
import com.treasuremountain.mango.core.page.PageRequest;
import com.treasuremountain.mango.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * 用户管理
 *
 * @author  mengyuanming
 * @date  2020/11/20 16:39
 * @version 1.0
 */
public interface SysUserService extends CurdService<SysUser> {

    /**
     * 查找所有用户
     *
     * @return
     */
    List<SysUser> findAll();

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @Override
    SysUser findById(Long id);

    /**
     * 通过用户名查询
     *
     * @param username
     * @return
     */
    SysUser findByName(String username);

    /**
     * 查找用户的菜单权限标识集合
     *
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    /**
     * 查找用户的角色集合
     *
     * @param userId
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);

    /**
     * 生成用户信息excel文件
     *
     * @param pageRequest
     * @return
     */
    File createUserExcelFile(PageRequest pageRequest);

}
