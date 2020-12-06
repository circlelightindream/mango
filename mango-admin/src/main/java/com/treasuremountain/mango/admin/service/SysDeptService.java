package com.treasuremountain.mango.admin.service;

import com.treasuremountain.mango.admin.model.SysDept;
import com.treasuremountain.mango.core.service.CurdService;

import java.util.List;

/**
 * 机构管理
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/7 0007 4:52
 */
public interface SysDeptService extends CurdService<SysDept> {

    /**
     * 查询机构树
     *
     * @return
     */
    List<SysDept> findTree();

}
