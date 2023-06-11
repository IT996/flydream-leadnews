package com.flydream.model.mappers.app;

import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.model.user.pojos.ApUser;
import com.flydream.model.user.pojos.ApUserArticleList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApUserArticleListMapper {
    //通过用户推荐表查询文章信息
    List<ApUserArticleList> loadArticleIdListByUser(@Param("user")ApUser user, @Param("dto")ArticleHomeDto dto,@Param("type") short type);
}
