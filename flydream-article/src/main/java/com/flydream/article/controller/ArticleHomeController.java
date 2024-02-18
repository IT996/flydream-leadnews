package com.flydream.article.controller;

import com.flydream.article.apis.ArticleHomeControllerApi;
import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.article.service.AppArticleService;
import com.flydream.common.article.constans.ArticleConstans;
import com.flydream.model.common.dtos.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2024年01月04日 9:50
 */
@RestController
@RequestMapping("/api/article")
public class ArticleHomeController implements ArticleHomeControllerApi {

    private AppArticleService appArticleService;

    @Override
    @GetMapping("/load")
    public ResponseResult load(ArticleHomeDto dto) {
        return appArticleService.load(dto, ArticleConstans.LOADTYPE_LOAD_MORE);
    }

    @Override
    @GetMapping("/loadmore")
    public ResponseResult loadMore(ArticleHomeDto dto) {
        return appArticleService.load(dto, ArticleConstans.LOADTYPE_LOAD_MORE);
    }

    @Override
    @GetMapping("/loadnew")
    public ResponseResult loadNew(ArticleHomeDto dto) {
        return appArticleService.load(dto,ArticleConstans.LOADTYPE_LOAD_NEW);
    }
}
