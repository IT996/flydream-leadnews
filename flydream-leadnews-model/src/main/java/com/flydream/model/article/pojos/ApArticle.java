package com.flydream.model.article.pojos;

import lombok.Data;
import com.flydream.model.annotation.DateConvert;
import com.flydream.model.annotation.IdEncrypt;

import java.util.Date;

/**
 * 功能描述
 *文章信息表，存储已发布的文章
 * @author: scott
 * @date: 2023年05月25日 16:09
 */
@Data
public class ApArticle {
    private Integer id;//主键
    private String title;//标题
    @IdEncrypt
    private Long authorId;//文章作者的ID
    private String authorName;//作者昵称
    @IdEncrypt
    private Integer channelId;//文章所属频道ID
    private String channelName;//频道名称
    private Short layout;//文章布局 0 无图文章 1 单图文章 2 多图文章
    private Byte flag;//文章标记 0 普通文章 1 热点文章 2 置顶文章 3 精品文章 4大V 文章
    private String images;//文章图片 多张逗号分隔
    private String labels;//文章标签最多3个 逗号分
    private Integer likes;//点赞数量
    private Integer collection;//收藏数量
    private Integer comment;//评论数量
    private Integer views;//阅读数量
    private Integer provinceId;//省市
    private Integer cityId;//市区
    private Integer countyId;//区县
    @DateConvert("yyyyMMddHHmmss")
    private Date createdTime ;//创建时间;
    @DateConvert("yyyyMMddHHmmss")
    private Date publishTime;//发布时间
    private Boolean syncStatus;//同步状态
    private Boolean origin;//来源
}
