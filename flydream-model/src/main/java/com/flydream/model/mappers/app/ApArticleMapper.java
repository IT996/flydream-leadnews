package com.flydream.model.mappers.app;

import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.model.article.pojos.ApArticle;
import com.flydream.model.user.pojos.ApUserArticleList;

import java.util.List;

public interface ApArticleMapper {
    List<ApArticle> loadArticleListByLocation(ArticleHomeDto dto, Short type);

    List<ApArticle> loadArticleListByIdList(List<ApUserArticleList> list);
}
