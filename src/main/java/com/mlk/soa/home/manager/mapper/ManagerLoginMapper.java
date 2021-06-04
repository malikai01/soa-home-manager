package com.mlk.soa.home.manager.mapper;

import com.mlk.soa.home.manager.model.po.ManagerLogin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author malikai
 * @date 2021-5-21 17:20
 */
@Repository
public interface ManagerLoginMapper {
    ManagerLogin login(@Param("loginName") String loginName, @Param("password") String password);

    ManagerLogin queryByLoginName(@Param("loginName") String loginName);

    int add(ManagerLogin model);
}
