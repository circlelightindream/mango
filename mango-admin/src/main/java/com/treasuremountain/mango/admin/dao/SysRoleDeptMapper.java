package com.treasuremountain.mango.admin.dao;

import com.treasuremountain.mango.admin.model.SysRoleDept;
import com.treasuremountain.mango.admin.model.SysRoleDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysRoleDeptMapper {
    long countByExample(SysRoleDeptExample example);

    int deleteByExample(SysRoleDeptExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDept record);

    int insertSelective(SysRoleDept record);

    List<SysRoleDept> selectByExampleWithRowbounds(SysRoleDeptExample example, RowBounds rowBounds);

    List<SysRoleDept> selectByExample(SysRoleDeptExample example);

    SysRoleDept selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRoleDept record, @Param("example") SysRoleDeptExample example);

    int updateByExample(@Param("record") SysRoleDept record, @Param("example") SysRoleDeptExample example);

    int updateByPrimaryKeySelective(SysRoleDept record);

    int updateByPrimaryKey(SysRoleDept record);
}