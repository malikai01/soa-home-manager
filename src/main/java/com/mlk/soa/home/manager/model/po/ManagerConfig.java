package com.mlk.soa.home.manager.model.po;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author malikai
 * @date 2021-5-21 16:31
 */
@Data
public class ManagerConfig implements Serializable {

    private static final long serialVersionUID = 8875782747476280365L;

    private String configKey;
    private String configValue;
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String memo;

}
