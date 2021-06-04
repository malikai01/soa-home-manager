package com.mlk.soa.home.manager.controller;

import com.mlk.soa.home.manager.model.DataResult;
import com.mlk.soa.home.manager.model.po.ManagerLogin;
import com.mlk.soa.home.manager.service.ManagerLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author malikai
 * @date 2021年05月25日 17:55
 */
@RestController
@Api("用户中心Controller")
@RequestMapping("/manager/user")
public class ManagerLoginController {
    @Autowired
    private ManagerLoginService managerLoginService;


    @PostMapping("/add")
    @ApiOperation(value = "新增", notes = "新增用户")
    public DataResult<Integer> add(@RequestBody ManagerLogin request) {
        return DataResult.ok(managerLoginService.register(request));
    }

    @GetMapping("/login")
    @ApiOperation(value = "登录查询", notes = "登录查询")
    public DataResult<ManagerLogin> login(@RequestParam String loginName, @RequestParam String password) {
        return DataResult.ok(managerLoginService.login(loginName, password));
    }

    @GetMapping("/queryByName")
    @ApiOperation(value = "根据用户名查询", notes = "根据用户名查询")
    public DataResult<ManagerLogin> queryByName(@RequestParam String loginName) {
        return DataResult.ok(managerLoginService.queryByLoginName(loginName));
    }
}
