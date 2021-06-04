package com.mlk.soa.home.manager.service.impl;

import com.mlk.soa.home.manager.mapper.ManagerFamilyGroupMapper;
import com.mlk.soa.home.manager.model.po.ManagerFamilyGroup;
import com.mlk.soa.home.manager.service.ManagerFamilyGroupService;
import com.mlk.soa.home.manager.utils.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author malikai
 * @date 2021年05月25日 17:53
 */
@Service
public class ManagerFamilyGroupServiceImpl implements ManagerFamilyGroupService {

    @Autowired
    private ManagerFamilyGroupMapper managerFamilyGroupMapper;

    @Override
    public Boolean binding(ManagerFamilyGroup group) {
        group.setCreateTime(new Date());
        group.setIsDelete("0");
        int result = 0;
        if (EmptyUtils.isNotEmpty(group.getId())) {
            group.setUpdateTime(new Date());
            result = managerFamilyGroupMapper.update(group);
        } else {
            result = managerFamilyGroupMapper.insert(group);
        }
        return result > 0;
    }

    @Override
    public Boolean cancelBinding(Long id) {
        int result = managerFamilyGroupMapper.cancelBinding(id);
        return result > 0;
    }

    @Override
    public List<ManagerFamilyGroup> queryByLoginId(Long loginId) {
        return managerFamilyGroupMapper.queryByLoginId(loginId);
    }
}
