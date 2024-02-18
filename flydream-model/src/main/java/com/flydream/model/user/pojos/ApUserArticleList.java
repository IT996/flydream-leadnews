package com.flydream.model.user.pojos;

import lombok.Data;

import java.util.Date;

/**
 * 功能描述
 * APP用户文章列表
 * @author: scott
 * @date: 2023年12月19日 11:02
 */
@Data
public class ApUserArticleList {
    private Integer id;
    private Integer userId;
    private Integer channelId;
    private Integer articleId;
    private Boolean isShow;
    private Date recommendTime;
    private Boolean isRead;
    private Integer strategyId;
}
