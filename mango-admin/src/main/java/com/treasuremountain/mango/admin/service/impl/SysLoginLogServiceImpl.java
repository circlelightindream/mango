package com.treasuremountain.mango.admin.service.impl;

import com.treasuremountain.mango.admin.dao.SysLoginLogMapper;
import com.treasuremountain.mango.admin.model.SysLoginLog;
import com.treasuremountain.mango.admin.service.SysLoginLogService;
import com.treasuremountain.mango.core.page.MybatisPageHelper;
import com.treasuremountain.mango.core.page.PageRequest;
import com.treasuremountain.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 登录日志管理
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/10 0010 16:56
 */
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {

    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;

    @Override
    public int save(SysLoginLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysLoginLogMapper.insertSelective(record);
        }
        return sysLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysLoginLog record) {
        return sysLoginLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLoginLog> records) {
        for (SysLoginLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLoginLog findById(Long id) {
        return sysLoginLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object userName = pageRequest.getParam("userName");
        if (userName != null) {
            return MybatisPageHelper.findPage(pageRequest, sysLoginLogMapper, "findPageByUserName", userName);
        }
        Object status = pageRequest.getParam("status");
        if (status != null) {
            return MybatisPageHelper.findPage(pageRequest, sysLoginLogMapper, "findPageByStatus", status);
        }
        return MybatisPageHelper.findPage(pageRequest, sysLoginLogMapper);
    }
}
