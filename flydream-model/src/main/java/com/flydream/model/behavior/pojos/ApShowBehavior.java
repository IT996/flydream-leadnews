package com.flydream.model.behavior.pojos;

import lombok.Data;

import java.util.Date;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2024年02月18日 14:08
 */
@Data
public class ApShowBehavior {
    private Integer id;
    private Integer entryId;
    private Integer articleId;
    private Boolean isClick;
    private Date showTime;
    private Date createdTime;
}
