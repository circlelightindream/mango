package com.treasuremountain.mango.admin.controller;

import com.treasuremountain.mango.admin.constants.SysContants;
import com.treasuremountain.mango.admin.dao.SysRoleMapper;
import com.treasuremountain.mango.admin.model.SysRole;
import com.treasuremountain.mango.admin.model.SysRoleMenu;
import com.treasuremountain.mango.admin.service.SysRoleService;
import com.treasuremountain.mango.core.http.HttpResult;
import com.treasuremountain.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色控制器
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/11 0011 12:16
 */
@RestController
@RequestMapping("role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysRole record) {
        SysRole role = sysRoleService.findById(record.getId());
        if (role != null) {
            if (SysContants.ADMIN.equalsIgnoreCase(role.getName())) {
                return HttpResult.error("超级管理员不允许修改！");
            }
        }
        // 新增角色
        boolean nameIsEmpty = sysRoleService.findByName(record.getName()).isEmpty();
        boolean idIsUsable = record.getId() == null || record.getId() == 0;

        if (idIsUsable && !nameIsEmpty) {
            return HttpResult.error("角色名已存在！");
        }
        return HttpResult.ok(sysRoleService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysRole> records) {
        return HttpResult.ok(sysRoleService.delete(records));
    }

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysRoleService.findPage(pageRequest));
    }

    @GetMapping(value = "/findAll")
    public HttpResult findAll() {
        return HttpResult.ok(sysRoleService.findAll());
    }

    @GetMapping(value = "/findRoleMenus")
    public HttpResult findRoleMenus(@RequestParam Long roleId) {
        return HttpResult.ok(sysRoleService.findRoleMenu(roleId));
    }

    @PostMapping(value = "/saveRoleMenus")
    public HttpResult findRoleMenus(@RequestBody List<SysRoleMenu> records) {
        for (SysRoleMenu record : records) {
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(record.getRoleId());
            if (SysContants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
                // 如果是超级管理员，不允许修改
                return HttpResult.error("超级管理员拥有所有菜单权限，不允许修改！");
            }
        }
        return HttpResult.ok(sysRoleService.saveRoleMenus(records));
    }
}
