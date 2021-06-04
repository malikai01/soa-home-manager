package com.mlk.soa.home.manager.service;

import com.mlk.soa.home.manager.model.po.ManagerFamilyGroup;

import java.util.List;

/**
 * @author malikai
 * @date 2021年05月25日 17:52
 */
public interface ManagerFamilyGroupService {

    Boolean binding(ManagerFamilyGroup group);

    Boolean cancelBinding(Long id);

    List<ManagerFamilyGroup> queryByLoginId(Long loginId);
}
