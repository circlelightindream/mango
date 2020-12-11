package com.treasuremountain.mango.admin.controller;

import ch.qos.logback.classic.net.SyslogAppender;
import com.treasuremountain.mango.admin.model.SysLog;
import com.treasuremountain.mango.admin.service.SysLogService;
import com.treasuremountain.mango.core.http.HttpResult;
import com.treasuremountain.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 操作日志控制器
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/11 0011 12:09
 */
@RestController
@RequestMapping("log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLogService.findPage(pageRequest));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysLog> records) {
        return HttpResult.ok(sysLogService.delete(records));
    }
}
