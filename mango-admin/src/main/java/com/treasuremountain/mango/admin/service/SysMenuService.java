package com.treasuremountain.mango.admin.service;

import com.treasuremountain.mango.admin.model.SysMenu;
import com.treasuremountain.mango.core.service.CurdService;

import java.util.List;

/**
 * 菜单管理
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/11/20 20:25
 */
public interface SysMenuService extends CurdService<SysMenu> {

    /**
     * 查询菜单树，用户ID和用户名为空则查询全部
     *
     * @param userName
     * @param menuType 获取菜单类型，0：获取所有菜单，包括按钮，1：获取所有菜单，不包括按钮
     * @return
     */
    List<SysMenu> findTree(String userName, int menuType);

    /**
     * 根据用户名查找菜单列表
     *
     * @param userName
     * @return
     */
    List<SysMenu> findByUser(String userName);

}
