package com.heima.behavior.test;

import com.flydream.behavior.BehaviorJarApplication;
import com.flydream.behavior.service.AppShowBehaviorService;
import com.flydream.model.article.pojos.ApArticle;
import com.flydream.model.behavior.dtos.ShowBehaviorDto;
import com.flydream.model.user.pojos.ApUser;
import com.flydream.utils.threadlocal.AppThreadLocalUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2023年06月19日 9:12
 */
@SpringBootTest(classes = BehaviorJarApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BehaviorTest {

    @Autowired
    private AppShowBehaviorService showBehaviorService;
    @Test
    public void testSaveBehavior() {
        ApUser apUser = new ApUser();
        apUser.setId(1l);
        AppThreadLocalUtils.setUser(apUser);
        ShowBehaviorDto dto = new ShowBehaviorDto();
        List<ApArticle> articles = new ArrayList<>();
        ApArticle apArticle = new ApArticle();
        apArticle.setId(1);
        articles.add(apArticle);
        dto.setEquipmentId(1);
        dto.setArticleIds(articles);
        showBehaviorService.saveShowBehavior(dto);
//articleIndexService.saveBehaviors(data);
    }
}
