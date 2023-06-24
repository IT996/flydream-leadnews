package com.flydream.model.behavior.pojos;

import lombok.Data;

import java.util.Date;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2023年06月16日 9:56
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
