package com.mlk.soa.home.manager.controller;

import com.mlk.soa.home.manager.model.DataResult;
import com.mlk.soa.home.manager.model.dto.sparename.SpareNamesAddRequest;
import com.mlk.soa.home.manager.model.dto.sparename.SpareNamesEditRequest;
import com.mlk.soa.home.manager.model.dto.sparename.SpareNamesQueryRequest;
import com.mlk.soa.home.manager.model.page.PageRequest;
import com.mlk.soa.home.manager.model.page.PageResponse;
import com.mlk.soa.home.manager.model.po.SpareNames;
import com.mlk.soa.home.manager.service.SpareNamesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author malikai
 * @date 2021年05月21日 17:25
 */
@RestController
@Api("备用名Controller")
@RequestMapping("/spareNames")
public class SpareNamesController {

    @Autowired
    private SpareNamesService spareNamesService;

    @GetMapping("/getById")
    @ApiOperation(value = "获取备用名", notes = "根据id获取备用名")
    public DataResult<SpareNames> queryById(@RequestParam Integer id) {
        return DataResult.ok(spareNamesService.queryById(id));
    }

    @PostMapping("/queryByPage")
    @ApiOperation(value = "分页获取列表", notes = "分页获取备用名列表")
    public DataResult<PageResponse<SpareNames>> queryByPage(@RequestBody PageRequest<SpareNamesQueryRequest> model) {
        return DataResult.ok(spareNamesService.queryNames(model));
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增", notes = "新增备用名")
    public DataResult<Boolean> add(@RequestBody SpareNamesAddRequest request) {
        return DataResult.ok(spareNamesService.addNames(request));
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新", notes = "更新备用名")
    public DataResult<Boolean> update(@RequestBody SpareNamesEditRequest request) {
        return DataResult.ok(spareNamesService.editNames(request));
    }
}
