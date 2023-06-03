package com.flydream.article.controller.v1;

import com.flydream.article.apis.ArticleHomeControllerApi;
import com.flydream.article.service.AppArticleService;
import com.flydream.common.article.constans.ArticleConstans;
import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2023年05月31日 20:28
 */
@RestController
@RequestMapping("/api/v1/article")
public class ArticleHomeController implements ArticleHomeControllerApi {

    @Autowired
    private AppArticleService appArticleService;


    @Override
    @PostMapping("/load")
    public ResponseResult load(ArticleHomeDto dto) {
        return appArticleService.load(dto, ArticleConstans.LOADTYPE_LOAD_MORE);
    }

    @Override
    @PostMapping("/loadmore")
    public ResponseResult loadMore(ArticleHomeDto dto) {
        return appArticleService.load(dto,ArticleConstans.LOADTYPE_LOAD_MORE);
    }

    @Override
    @PostMapping("/loadnew")
    public ResponseResult loadNew(ArticleHomeDto dto) {
        return  appArticleService.load(dto,ArticleConstans.LOADTYPE_LOAD_NEW);
    }
}
