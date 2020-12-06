package com.treasuremountain.mango.admin.dao;

import com.treasuremountain.mango.admin.model.SysDict;
import com.treasuremountain.mango.admin.model.SysDictExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * 机构管理
 *
 * @author  mengyuanming
 * @date  2020/11/14 16:54
 * @version 1.0
 */
@Repository
public interface SysDictMapper {
    long countByExample(SysDictExample example);

    int deleteByExample(SysDictExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    List<SysDict> selectByExampleWithRowbounds(SysDictExample example, RowBounds rowBounds);

    List<SysDict> selectByExample(SysDictExample example);

    SysDict selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

    /**
     * 分页查询
     * @return
     */
    List<SysDict> findPage();

    /**
     * 根据标签名称查询
     * @param label
     * @return
     */
    List<SysDict> findByLabel(@Param(value = "label") String label);

    /**
     * 根据标签名称分页查询
     * @param label
     * @return
     */
    List<SysDict> findPageByLabel(@Param(value = "label") String label);

}