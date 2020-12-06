package com.treasuremountain.mango.admin.service.impl;

import com.treasuremountain.mango.admin.dao.SysDictMapper;
import com.treasuremountain.mango.admin.model.SysDict;
import com.treasuremountain.mango.admin.service.SysDictService;
import com.treasuremountain.mango.core.page.MybatisPageHelper;
import com.treasuremountain.mango.core.page.PageRequest;
import com.treasuremountain.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典管理实现
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/11/14 17:18
 */
@Service
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> findByLabel(String label) {
        return sysDictMapper.findByLabel(label);
    }

    @Override
    public int save(SysDict record) {

        if (record.getId() == null || record.getId() == 0) {
            return sysDictMapper.insertSelective(record);
        }

        return sysDictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysDict record) {
        return sysDictMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDict> records) {
        for (SysDict record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysDict findById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {

        Object label = pageRequest.getParam("label");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel", label);
        }

        return MybatisPageHelper.findPage(pageRequest, sysDictMapper);
    }
}
