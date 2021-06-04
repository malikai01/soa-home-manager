package com.mlk.soa.home.manager.service.impl;

import com.mlk.soa.home.manager.mapper.ManagerLoginMapper;
import com.mlk.soa.home.manager.model.po.ManagerLogin;
import com.mlk.soa.home.manager.service.ManagerLoginService;
import com.mlk.soa.home.manager.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author malikai
 * @date 2021-5-21 17:19
 */
@Service
public class ManagerLoginServiceImpl implements ManagerLoginService {
    @Autowired
    private ManagerLoginMapper managerLoginMapper;

    @Override
    public Integer register(ManagerLogin model) {
        model.setPassword(MD5Util.getMD5(model.getPassword()));
        model.setRegisterTime(new Date());
        model.setIsDelete("0");
        managerLoginMapper.add(model);
        return model.getId();
    }

    @Override
    public ManagerLogin login(String loginName, String password) {
        return managerLoginMapper.login(loginName, password);
    }

    @Override
    public ManagerLogin queryByLoginName(String loginName) {
        return managerLoginMapper.queryByLoginName(loginName);
    }
}
