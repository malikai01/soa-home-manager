package com.mlk.soa.home.manager.controller;

import com.mlk.soa.home.manager.model.DataResult;
import com.mlk.soa.home.manager.model.po.ManagerFamilyGroup;
import com.mlk.soa.home.manager.service.ManagerFamilyGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author malikai
 * @date 2021年05月25日 17:56
 */
@RestController
@Api("家庭关系Controller")
@RequestMapping("/manager/family")
public class ManagerFamilyController {
    @Autowired
    private ManagerFamilyGroupService familyGroupService;

    @GetMapping("/queryByLoginId")
    @ApiOperation(value = "根据用户id查询家庭成员", notes = "根据用户id查询家庭成员")
    public DataResult<List<ManagerFamilyGroup>> queryByLoginId(@RequestParam Long loginId) {
        return DataResult.ok(familyGroupService.queryByLoginId(loginId));
    }

    @GetMapping("/cancelBinding")
    @ApiOperation(value = "解绑", notes = "解绑家庭组")
    public DataResult<Boolean> cancelBinding(@RequestParam Long loginId) {
        return DataResult.ok(familyGroupService.cancelBinding(loginId));
    }


    @PostMapping("/binding")
    @ApiOperation(value = "绑定", notes = "绑定家庭组")
    public DataResult<Boolean> binding(@RequestBody ManagerFamilyGroup familyGroup) {
        return DataResult.ok(familyGroupService.binding(familyGroup));
    }
}
