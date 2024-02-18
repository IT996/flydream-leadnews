package com.flydream.model.mappers.app;

import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.model.user.pojos.ApUser;
import com.flydream.model.user.pojos.ApUserArticleList;

import java.util.List;

public interface ApUserArticleListMapper {
    List<ApUserArticleList> loadArticleIdListByUser(ApUser user, ArticleHomeDto dto, short type);
}
