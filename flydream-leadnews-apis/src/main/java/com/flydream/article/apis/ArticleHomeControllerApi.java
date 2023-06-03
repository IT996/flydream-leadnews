package com.flydream.article.apis;

import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.model.common.dtos.ResponseResult;

public interface ArticleHomeControllerApi {

    /**
     *加载首页文章
     * @param dto  封装参数对象
     * @return 文章列表数据
     */
    public ResponseResult load(ArticleHomeDto dto);

    /**
     *加载更多
     * @param dto
     * @return
     */
    public ResponseResult loadMore(ArticleHomeDto dto);

    /**
     * 加载最新
     * @param dto
     * @return
     */
    public ResponseResult loadNew(ArticleHomeDto dto);


}
