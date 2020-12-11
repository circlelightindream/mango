package com.treasuremountain.mango.admin.service;

import com.treasuremountain.mango.admin.model.SysMenu;
import com.treasuremountain.mango.admin.model.SysRole;
import com.treasuremountain.mango.admin.model.SysRoleMenu;
import com.treasuremountain.mango.core.service.CurdService;

import java.util.List;

/**
 * 角色管理
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/8 0008 1:03
 */
public interface SysRoleService extends CurdService<SysRole> {

    /**
     * 查询全部
     *
     * @return
     */
    List<SysRole> findAll();

    /**
     * 查询角色菜单集合
     *
     * @param roleId
     * @return
     */
    List<SysMenu> findRoleMenu(Long roleId);

    /**
     * 保存角色菜单
     *
     * @param records
     * @return
     */
    int saveRoleMenus(List<SysRoleMenu> records);

    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    List<SysRole> findByName(String name);

}
