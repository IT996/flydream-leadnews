package com.flydream.article.controller.test;

import com.flydream.article.ArticleJarApplication;
import com.flydream.article.service.AppArticleService;
import com.flydream.common.article.constans.ArticleConstans;
import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.model.common.dtos.ResponseResult;
import com.flydream.model.user.pojos.ApUser;
import com.flydream.utils.threadlocal.AppThreadLocalUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2023年06月11日 22:36
 */
@SpringBootTest(classes = ArticleJarApplication.class)
@RunWith(SpringRunner.class)
public class ArticleTest {
    @Autowired
    private AppArticleService appArticleService;

    @Test
    public void tesrload(){
        ApUser apUser = new ApUser();
        apUser.setId(1l);
        AppThreadLocalUtils.setUser(apUser);
        ArticleHomeDto articleHomeDto = new ArticleHomeDto();
        ResponseResult load = appArticleService.load(articleHomeDto, ArticleConstans.LOADTYPE_LOAD_MORE);
        System.out.println(load.getCode());
    }
}
