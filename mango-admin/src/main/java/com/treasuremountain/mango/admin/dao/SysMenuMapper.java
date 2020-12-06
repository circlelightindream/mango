package com.treasuremountain.mango.admin.dao;

import com.treasuremountain.mango.admin.model.SysMenu;
import com.treasuremountain.mango.admin.model.SysMenuExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单管理
 *
 * @author  mengyuanming
 * @date  2020/11/20 19:28
 * @version 1.0
 */
@Repository
public interface SysMenuMapper {
    long countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExampleWithRowbounds(SysMenuExample example, RowBounds rowBounds);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> findPage();

    List<SysMenu> findPageByName(@Param(value = "name") String name);

    List<SysMenu> findAll();

    List<SysMenu> findByUserName(@Param(value = "userName") String userName);

    List<SysMenu> findRoleMenu(@Param(value = "roleId") String roleId);

}