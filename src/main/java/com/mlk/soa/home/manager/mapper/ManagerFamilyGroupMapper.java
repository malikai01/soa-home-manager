package com.mlk.soa.home.manager.mapper;

import com.mlk.soa.home.manager.model.po.ManagerFamilyGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author malikai
 * @date 2021-5-21 17:20
 */
@Repository
public interface ManagerFamilyGroupMapper {
    List<ManagerFamilyGroup> queryByLoginId(@Param("loginId") Long loginId);

    int cancelBinding(@Param("id") Long id);

    int update(ManagerFamilyGroup group);

    int insert(ManagerFamilyGroup group);
}
