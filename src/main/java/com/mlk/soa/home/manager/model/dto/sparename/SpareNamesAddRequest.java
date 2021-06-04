package com.mlk.soa.home.manager.model.dto.sparename;

import lombok.Data;

import java.io.Serializable;

/**
 * @author malikai
 * @date 2021年05月25日 16:52
 */
@Data
public class SpareNamesAddRequest implements Serializable{
    private static final long serialVersionUID = 1836044609698052791L;

    private String name;

    private String type;

    private String memo;

    private String isShow;

    private Integer familyId;
}
