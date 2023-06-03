package com.flydream.article.service;

import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.model.common.dtos.ResponseResult;

public interface AppArticleService {
    ResponseResult load(ArticleHomeDto dto, Short type);
}
