package com.mlk.soa.home.manager.controller;

import com.mlk.soa.home.manager.model.DataResult;
import com.mlk.soa.home.manager.model.dto.managerconfig.ManagerConfigQueryRequest;
import com.mlk.soa.home.manager.model.dto.managerconfig.ManagerConfigRequest;
import com.mlk.soa.home.manager.model.page.PageRequest;
import com.mlk.soa.home.manager.model.page.PageResponse;
import com.mlk.soa.home.manager.model.po.ManagerConfig;
import com.mlk.soa.home.manager.service.ManagerConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author malikai
 * @date 2021年05月25日 17:03
 */
@RestController
@Api("配置中心Controller")
@RequestMapping("/manager/config")
public class ManagerConfigController {

    @Autowired
    private ManagerConfigService managerConfigService;

    @GetMapping("/getById")
    @ApiOperation(value = "获取配置", notes = "根据key获取配置value")
    public DataResult<ManagerConfig> queryConfigByKey(@RequestParam String configKey) {
        return DataResult.ok(managerConfigService.queryByConfigKey(configKey));
    }

    @PostMapping("/queryByPage")
    @ApiOperation(value = "配置列表", notes = "分页获取配置列表")
    public DataResult<PageResponse<ManagerConfig>> queryByPage(@RequestBody PageRequest<ManagerConfigQueryRequest> model) {
        return DataResult.ok(managerConfigService.queryManagerConfigByPage(model));
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增", notes = "新增配置")
    public DataResult<Boolean> add(@RequestBody ManagerConfigRequest request) {
        return DataResult.ok(managerConfigService.addManagerConfig(request));
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新", notes = "更新配置")
    public DataResult<Boolean> update(@RequestBody ManagerConfigRequest request) {
        return DataResult.ok(managerConfigService.editManagerConfig(request));
    }
}
