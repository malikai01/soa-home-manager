package com.mlk.soa.home.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlk.soa.home.manager.mapper.ManagerConfigMapper;
import com.mlk.soa.home.manager.model.dto.managerconfig.ManagerConfigQueryRequest;
import com.mlk.soa.home.manager.model.dto.managerconfig.ManagerConfigRequest;
import com.mlk.soa.home.manager.model.page.PageRequest;
import com.mlk.soa.home.manager.model.page.PageResponse;
import com.mlk.soa.home.manager.model.po.ManagerConfig;
import com.mlk.soa.home.manager.service.ManagerConfigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author malikai
 * @date 2021-5-21 17:19
 */
@Service
public class ManagerConfigServiceImpl implements ManagerConfigService {
    @Autowired
    private ManagerConfigMapper managerConfigMapper;

    @Override
    public ManagerConfig queryByConfigKey(String configKey) {
        return managerConfigMapper.queryByConfigKey(configKey);
    }

    @Override
    public boolean editManagerConfig(ManagerConfigRequest request) {
        ManagerConfig config = new ManagerConfig();
        BeanUtils.copyProperties(request,config);

        return managerConfigMapper.edit(config) > 0;
    }

    @Override
    public boolean addManagerConfig(ManagerConfigRequest request) {
        ManagerConfig config = new ManagerConfig();
        BeanUtils.copyProperties(request,config);
        return managerConfigMapper.add(config) > 0;
    }

    @Override
    public PageResponse<ManagerConfig> queryManagerConfigByPage(PageRequest<ManagerConfigQueryRequest> pageRequest) {

        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<ManagerConfig> configs = managerConfigMapper.queryManagerConfigByPage(pageRequest.getParamData().getConfigKey());
        PageInfo<ManagerConfig> pageInfo = new PageInfo<>(configs);

        PageResponse<ManagerConfig> response = new PageResponse<>();
        response.setResultData(pageInfo.getList());
        response.getPagination().setTotalCount(pageInfo.getTotal());
        response.getPagination().setCurrentPageIndex(pageRequest.getPageNum());
        response.getPagination().setPageSize(pageRequest.getPageSize());
        return response;
    }
}
