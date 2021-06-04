package com.mlk.soa.home.manager.model.dto.sparename;

import lombok.Data;

import java.io.Serializable;

/**
 * @author malikai
 * @date 2021年05月25日 16:52
 */
@Data
public class SpareNamesEditRequest implements Serializable {
    private static final long serialVersionUID = 1657109819883912734L;

    private Integer id;

    private String name;

    private String type;

    private String memo;

    private String isShow;

    private Integer familyId;
}
