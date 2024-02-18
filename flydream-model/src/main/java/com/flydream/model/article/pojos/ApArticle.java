package com.flydream.model.article.pojos;

import com.flydream.model.annotation.DateConvert;
import com.flydream.model.annotation.IdEncrypt;
import lombok.Data;

import java.util.Date;

/**
 * 功能描述
 *文章信息表
 * @author: scott
 * @date: 2023年12月19日 10:44
 */
@Data
public class ApArticle {

    private Integer id;
    private String title;//标题
    //是一个Java注解，用于标识需要加密的字段。这个注解可以应用于类、方法或字段上，以指示哪些字段需要进行加密处理。
    @IdEncrypt
    private Long authorId;//文章作者的ID
    private String authorName;//作者昵称
    @IdEncrypt
    private Integer channelId;//文章所属频道ID
    private String channelName;//频道名称
    private Short layout;//文章布局 0 无图文章 1 单图文章 2 多图文章
    private Byte flag;//文章标记 0 普通文章 1 热点文章 2 置顶文章 3 精品文章 4 大V 文章
    private String images;//文章图片 多张逗号分隔
    private String labels;//文章标签最多3个 逗号分隔
    private Integer likes;//点赞数量
    private Integer collection;//收藏数量
    private Integer comment;//评论数量
    private Integer views;//阅读数量
    private Integer provinceId;//省市
    private Integer cityId;//市区
    private Integer countyId;//区县
    @DateConvert("yyyyMMddHHmmss")
    private Date createdTime;//创建时间
    @DateConvert("yyyyMMddHHmmss")
    private Date publishTime;//发布时间
    private Boolean syncStatus;//同步状态
    private Boolean origin;//来源

}
