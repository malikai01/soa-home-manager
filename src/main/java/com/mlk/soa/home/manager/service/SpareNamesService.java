package com.mlk.soa.home.manager.service;


import com.mlk.soa.home.manager.model.dto.sparename.SpareNamesAddRequest;
import com.mlk.soa.home.manager.model.dto.sparename.SpareNamesEditRequest;
import com.mlk.soa.home.manager.model.dto.sparename.SpareNamesQueryRequest;
import com.mlk.soa.home.manager.model.page.PageRequest;
import com.mlk.soa.home.manager.model.page.PageResponse;
import com.mlk.soa.home.manager.model.po.SpareNames;

/**
 * @author malikai
 * @date 2021-5-21 16:35
 */
public interface SpareNamesService {
    boolean addNames(SpareNamesAddRequest names);

    PageResponse<SpareNames> queryNames(PageRequest<SpareNamesQueryRequest> model);

    SpareNames queryById(Integer cId);

    boolean editNames(SpareNamesEditRequest names);
}
