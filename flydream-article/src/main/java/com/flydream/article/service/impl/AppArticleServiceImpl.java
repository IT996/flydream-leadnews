package com.flydream.article.service.impl;

import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.model.article.pojos.ApArticle;
import com.flydream.article.service.AppArticleService;
import com.flydream.common.article.constans.ArticleConstans;
import com.flydream.model.mappers.app.ApArticleMapper;
import com.flydream.model.mappers.app.ApUserArticleListMapper;
import com.flydream.model.common.dtos.ResponseResult;
import com.flydream.model.user.pojos.ApUser;
import com.flydream.model.user.pojos.ApUserArticleList;
import com.flydream.utils.threadlocal.AppThreadLocalUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2024年01月04日 10:09
 */
@Service
@Log4j2
@SuppressWarnings("all")
public class AppArticleServiceImpl implements AppArticleService {

    private static final short MAX_PAGE_SIZE = 50;


    /**
     *
     * @param time 时间节点
     * @param type 1 加载更多 2 加载更新
     * @param size 每次返回数据量
     * @return 数据列表
     */
    @Override
    public ResponseResult load(ArticleHomeDto dto, short type) {

        //校验参数
        if (dto ==null){
            dto=new ArticleHomeDto();
        }

        //时间校验
        if (dto.getMaxBehotTime()==null){
            dto.setMaxBehotTime(new Date());
        }
        if (dto.getMinBehotTime()==null){
            dto.setMinBehotTime(new Date());
        }

        //分页参数校验
        Integer size = dto.getSize();
        if (size==null ||size<=0){
            size=20;
        }

        size=Math.min(size,MAX_PAGE_SIZE);
        dto.setSize(size);

        //文章频道校验
        if (StringUtils.isEmpty(dto.getTag())){
            dto.setTag(ArticleConstans.DEFAULT_TAG);
        }

        //类型参数校验
        if(type!=ArticleConstans.LOADTYPE_LOAD_MORE &&type!=ArticleConstans.LOADTYPE_LOAD_NEW){
            type = ArticleConstans.LOADTYPE_LOAD_MORE;
        }

        //获取用户信息
        ApUser user = AppThreadLocalUtils.getUser();

        //判断用户是否存在
        if (user !=null){
            //已登录 加载推荐的文章
            List<ApArticle> apArticleList = getUserArticle(user,dto,type);
            return ResponseResult.okResult(apArticleList);
        }else{
            //未登录 加载默认文章
            List<ApArticle> apArticles = getDefaultArticle(dto,type);
            return ResponseResult.okResult(apArticles);
        }


    }



    @Autowired
    private ApArticleMapper apArticleMapper;

    /**
     * 加载默认的文章信息
     * @param dto
     * @param type
     * @return
     */
    private List<ApArticle> getDefaultArticle(ArticleHomeDto dto, Short type) {
        return apArticleMapper.loadArticleListByLocation(dto,type);
    }

    @Autowired
    private ApUserArticleListMapper apUserArticleListMapper;

    /**
     * 先从用户的推荐表中查找文章信息，如果没有再从默认文章信息获取数据
     * @param user
     * @param dto
     * @param type
     * @return
     */
    private List<ApArticle> getUserArticle(ApUser user, ArticleHomeDto dto, short type) {
        List<ApUserArticleList> list = apUserArticleListMapper.loadArticleIdListByUser(user,dto,type);
        if(!list.isEmpty()){
            return apArticleMapper.loadArticleListByIdList(list);
        }else{
            return getDefaultArticle(dto,type);
        }
    }
}
