package com.flydream.model.article.pojos;

import lombok.Data;
import com.flydream.model.annotation.DateConvert;
import com.flydream.model.annotation.IdEncrypt;

import java.util.Date;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2023年05月25日 16:09
 */
@Data
public class ApArticle {
    private Integer id;
    private String title;
    @IdEncrypt
    private Long authorId;
    private String authorName;
    @IdEncrypt
    private Integer channelId;
    private String channelName;
    private Short layout;
    private Byte flag;
    private String images;
    private String labels;
    private Integer likes;
    private Integer collection;
    private Integer comment;
    private Integer views;
    private Integer provinceId;
    private Integer cityId;
    private Integer countyId;
    @DateConvert("yyyyMMddHHmmss")
    private Date createdTime;
    @DateConvert("yyyyMMddHHmmss")
    private Date publishTime;
    private Boolean syncStatus;
    private Boolean origin;
}
