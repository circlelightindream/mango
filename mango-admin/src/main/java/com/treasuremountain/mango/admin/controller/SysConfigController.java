package com.treasuremountain.mango.admin.controller;

import com.treasuremountain.mango.admin.model.SysConfig;
import com.treasuremountain.mango.admin.service.SysConfigService;
import com.treasuremountain.mango.core.http.HttpResult;
import com.treasuremountain.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统配置控制器
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/11 0011 12:02
 */
@RestController
@RequestMapping("config")
public class SysConfigController {

    @Autowired
    private SysConfigService sysConfigService;

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysConfig record) {
        return HttpResult.ok(sysConfigService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysConfig> records) {
        return HttpResult.ok(sysConfigService.delete(records));
    }

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysConfigService.findPage(pageRequest));
    }

    @GetMapping(value = "/findBylabel")
    public HttpResult findByLabel(@RequestParam String label) {
        return HttpResult.ok(sysConfigService.findByLabel(label));
    }
}
