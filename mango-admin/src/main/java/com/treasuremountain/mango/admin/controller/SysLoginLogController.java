package com.treasuremountain.mango.admin.controller;

import com.alibaba.druid.sql.PagerUtils;
import com.treasuremountain.mango.admin.model.SysLoginLog;
import com.treasuremountain.mango.admin.service.SysLoginLogService;
import com.treasuremountain.mango.core.http.HttpResult;
import com.treasuremountain.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 登录日志控制器
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/11 0011 12:12
 */
@RestController
@RequestMapping("loginlog")
public class SysLoginLogController {

    @Autowired
    private SysLoginLogService sysLoginLogService;

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysLoginLog> records) {
        return HttpResult.ok(sysLoginLogService.delete(records));
    }
}
