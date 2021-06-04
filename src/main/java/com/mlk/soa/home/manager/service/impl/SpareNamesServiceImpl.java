package com.mlk.soa.home.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mlk.soa.home.manager.mapper.SpareNamesMapper;
import com.mlk.soa.home.manager.model.dto.sparename.SpareNamesAddRequest;
import com.mlk.soa.home.manager.model.dto.sparename.SpareNamesEditRequest;
import com.mlk.soa.home.manager.model.dto.sparename.SpareNamesQueryRequest;
import com.mlk.soa.home.manager.model.page.PageRequest;
import com.mlk.soa.home.manager.model.page.PageResponse;
import com.mlk.soa.home.manager.model.po.SpareNames;
import com.mlk.soa.home.manager.service.SpareNamesService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author malikai
 * @date 2021-5-21 17:19
 */
@Service
public class SpareNamesServiceImpl implements SpareNamesService {
    @Autowired
    private SpareNamesMapper takeNamesMapper;

    @Override
    public boolean addNames(SpareNamesAddRequest request) {
        SpareNames spareNames = new SpareNames();
        BeanUtils.copyProperties(request, spareNames, SpareNames.class);

        return takeNamesMapper.add(spareNames) > 0;
    }

    @Override
    public PageResponse<SpareNames> queryNames(PageRequest<SpareNamesQueryRequest> model) {

        int pageNum = model.getPageNum();
        int pageSize = model.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SpareNames> spareNames = takeNamesMapper.queryNamesByPage(model.getParamData());
        PageInfo<SpareNames> pageInfo = new PageInfo<>(spareNames);

        PageResponse<SpareNames> response = new PageResponse<>();
        response.setResultData(pageInfo.getList());
        response.getPagination().setTotalCount(pageInfo.getTotal());
        response.getPagination().setCurrentPageIndex(model.getPageNum());
        response.getPagination().setPageSize(model.getPageSize());
        return response;
    }

    @Override
    public SpareNames queryById(Integer cId) {
        return takeNamesMapper.queryById(cId);
    }

    @Override
    public boolean editNames(SpareNamesEditRequest names) {
        SpareNames spareNames = new SpareNames();
        BeanUtils.copyProperties(names, spareNames, SpareNames.class);
        return takeNamesMapper.edit(spareNames) > 0;
    }
}
