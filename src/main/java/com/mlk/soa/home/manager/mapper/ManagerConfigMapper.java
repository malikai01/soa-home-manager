package com.mlk.soa.home.manager.mapper;


import com.mlk.soa.home.manager.model.dto.managerconfig.ManagerConfigQueryRequest;
import com.mlk.soa.home.manager.model.po.ManagerConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author malikai
 * @date 2021-5-21 16:42
 */
@Repository
public interface ManagerConfigMapper {
    ManagerConfig queryByConfigKey(@Param("configKey") String configKey);

    List<ManagerConfig> queryManagerConfigByPage(@Param("configKey") String configKey);

    int edit(ManagerConfig managerConfig);

    int add(ManagerConfig managerConfig);
}