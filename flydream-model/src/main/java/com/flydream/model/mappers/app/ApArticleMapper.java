package com.flydream.model.mappers.app;

import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.model.article.pojos.ApArticle;
import com.flydream.model.user.pojos.ApUserArticleList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApArticleMapper {
    List<ApArticle> loadArticleListByLocation(@Param("dto") ArticleHomeDto dto, @Param("type") Short type);

    List<ApArticle> loadArticleListByIdList(List<ApUserArticleList> list);
}
