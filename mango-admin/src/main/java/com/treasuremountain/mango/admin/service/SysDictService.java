package com.treasuremountain.mango.admin.service;

import com.treasuremountain.mango.admin.model.SysDict;
import com.treasuremountain.mango.core.service.CurdService;

import java.util.List;

/**
 * 字典管理
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/11/14 17:15
 */
public interface SysDictService extends CurdService<SysDict> {

    /**
     * 根据名称查询
     *
     * @param label
     * @return
     */
    List<SysDict> findByLabel(String label);

}
