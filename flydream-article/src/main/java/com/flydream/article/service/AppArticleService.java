package com.flydream.article.service;

import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.model.common.dtos.ResponseResult;

public interface AppArticleService {

    /**
     *
     * @param type 1 加载更多 2 加载更新
     * @param dto 封装数据
     * @return 数据列表
     */
    ResponseResult load(ArticleHomeDto dto, short loadtypeLoadMore);
}
