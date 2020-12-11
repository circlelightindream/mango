package com.treasuremountain.mango.admin.service;

import com.treasuremountain.mango.admin.model.SysConfig;
import com.treasuremountain.mango.core.service.CurdService;

import java.util.List;

/**
 * 系统配置管理
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/9 0009 15:18
 */
public interface SysConfigService extends CurdService<SysConfig> {

    /**
     * 根据标签查询
     *
     * @param label
     * @return
     */
    List<SysConfig> findByLabel(String label);

}
