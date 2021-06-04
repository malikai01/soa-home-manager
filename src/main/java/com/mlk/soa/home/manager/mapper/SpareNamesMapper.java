package com.mlk.soa.home.manager.mapper;

import com.mlk.soa.home.manager.model.dto.sparename.SpareNamesQueryRequest;
import com.mlk.soa.home.manager.model.po.SpareNames;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author malikai
 * @date 2021-5-21 17:20
 */
@Repository
public interface SpareNamesMapper {
    List<SpareNames> queryNamesByPage(SpareNamesQueryRequest model);

    SpareNames queryById(@Param("id") Integer cId);

    int add(SpareNames names);

    int edit(SpareNames names);
}