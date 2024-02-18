package com.flydream.test;

import com.flydream.article.ArticleJarApplication;
import com.flydream.article.service.AppArticleService;
import com.flydream.common.article.constans.ArticleConstans;
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
 * @date: 2024年02月18日 15:32
 */
@SpringBootTest(classes= ArticleJarApplication.class)
@RunWith(SpringRunner.class)
public class ArticleTest {
    @Autowired
    private AppArticleService appArticleService;

    @Test
    public void testArticle(){
        ApUser apUser = new ApUser();
        apUser.setId(2104l);
        AppThreadLocalUtils.setUser(apUser);
        ResponseResult result = appArticleService.load(null, ArticleConstans.LOADTYPE_LOAD_MORE);
        System.out.println(result.getData());
    }
}
