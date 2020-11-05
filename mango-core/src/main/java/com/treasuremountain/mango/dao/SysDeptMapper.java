package com.treasuremountain.mango.dao;

import com.treasuremountain.mango.model.SysDept;
import com.treasuremountain.mango.model.SysDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysDeptMapper {
    long countByExample(SysDeptExample example);

    int deleteByExample(SysDeptExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    List<SysDept> selectByExampleWithRowbounds(SysDeptExample example, RowBounds rowBounds);

    List<SysDept> selectByExample(SysDeptExample example);

    SysDept selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    int updateByExample(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);
}