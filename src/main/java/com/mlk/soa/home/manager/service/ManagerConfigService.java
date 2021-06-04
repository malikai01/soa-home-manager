package com.mlk.soa.home.manager.service;


import com.mlk.soa.home.manager.model.dto.managerconfig.ManagerConfigQueryRequest;
import com.mlk.soa.home.manager.model.dto.managerconfig.ManagerConfigRequest;
import com.mlk.soa.home.manager.model.page.PageRequest;
import com.mlk.soa.home.manager.model.page.PageResponse;
import com.mlk.soa.home.manager.model.po.ManagerConfig;

/**
 * @author malikai
 * @date 2021-5-21 16:37
 */
public interface ManagerConfigService {

    ManagerConfig queryByConfigKey(String configKey);

    boolean editManagerConfig(ManagerConfigRequest managerConfig);

    boolean addManagerConfig(ManagerConfigRequest managerConfig);

    PageResponse<ManagerConfig> queryManagerConfigByPage(PageRequest<ManagerConfigQueryRequest> pageRequest);
}
