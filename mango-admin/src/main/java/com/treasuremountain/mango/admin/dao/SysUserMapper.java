package com.treasuremountain.mango.admin.dao;

import com.treasuremountain.mango.admin.model.SysUser;
import com.treasuremountain.mango.admin.model.SysUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExampleWithRowbounds(SysUserExample example, RowBounds rowBounds);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 查询全部
     *
     * @return
     */
    List<SysUser> findAll();

    /**
     * 分页查询
     *
     * @return
     */
    List<SysUser> findPage();

    /**
     * 按名称查询
     *
     * @param name
     * @return
     */
    SysUser findByName(@Param(value = "name") String name);

    /**
     * 通过名称分页查询
     *
     * @param name
     * @return
     */
    List<SysUser> findPageByName(@Param(value = "name") String name);

    /**
     * 通过名称和邮箱分页查询
     *
     * @param name
     * @param email
     * @return
     */
    List<SysUser> findPageByNameAndEmail(@Param(value = "name") String name, @Param(value = "email") String email);

}