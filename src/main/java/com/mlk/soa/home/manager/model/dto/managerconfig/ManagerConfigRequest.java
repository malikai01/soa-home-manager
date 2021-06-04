package com.mlk.soa.home.manager.model.dto.managerconfig;

import lombok.Data;

import java.io.Serializable;

/**
 * @author malikai
 * @date 2021年05月25日 17:10
 */
@Data
public class ManagerConfigRequest implements Serializable{
    private static final long serialVersionUID = 7159829938805741061L;

    private String configKey;
    private String configValue;
    private String createUser;
    private String memo;
}
