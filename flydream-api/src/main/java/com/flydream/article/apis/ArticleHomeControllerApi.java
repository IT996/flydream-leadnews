package com.flydream.article.apis;

import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.model.common.dtos.ResponseResult;

public interface ArticleHomeControllerApi {


    /**
     * 加载首页文章
     * @param dto
     * @return 文章列表
     */
    public ResponseResult load(ArticleHomeDto dto);

    /**
     * 加载更多
     * @param dto
     * @return 文章列表
     */
    public ResponseResult loadMore(ArticleHomeDto dto);

    /**
     * 加载最新
     * @param dto
     * @return 文章列表
     */
    public ResponseResult loadNew(ArticleHomeDto dto);
}
