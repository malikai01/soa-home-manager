package com.mlk.soa.home.manager.service;


import com.mlk.soa.home.manager.model.po.ManagerLogin;


/**
 * @author malikai
 * @date 2021-5-21 16:36
 */
public interface ManagerLoginService {
    Integer register(ManagerLogin model);

    ManagerLogin login(String loginName, String password);

    ManagerLogin queryByLoginName(String loginName);
}
