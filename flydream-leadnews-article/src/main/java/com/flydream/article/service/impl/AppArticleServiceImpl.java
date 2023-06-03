package com.flydream.article.service.impl;

import com.flydream.article.service.AppArticleService;
import com.flydream.common.article.constans.ArticleConstans;
import com.flydream.model.article.dtos.ArticleHomeDto;
import com.flydream.model.common.dtos.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2023年05月31日 20:45
 */
@Service
@SuppressWarnings("all")
public class AppArticleServiceImpl implements AppArticleService {

    private  static final short MAX_PAGE_SIZE=50;
    /**
     *
     * @param time 时间节点
     * @param type 1 加载更多 2 加载更新
     * @param size 每次返回数据量
     * @return 数据列表
     */
    @Override
    public ResponseResult load(ArticleHomeDto dto, Short type) {

        //参数校验
        if (dto == null){
            dto=new ArticleHomeDto();
        }

        //时间校验
        if (dto.getMaxBehotTime()==null){
            dto.setMaxBehotTime(new Date());
        }

        if (dto.getMinBehotTime() ==null){
            dto.setMinBehotTime(new Date());
        }

        //分页参数校验
        Integer size = dto.getSize();
        if(size ==null||size<=0){
            size=20;
        }
        size = Math.min(size, MAX_PAGE_SIZE);
        dto.setSize(size);

        //文章频道校验
        if (StringUtils.isEmpty(dto.getTag())){
            dto.setTag(ArticleConstans.DEFAULT_TAG);
        }

        //类型参数校验
        if (!type.equals(ArticleConstans.LOADTYPE_LOAD_MORE)&&!type.equals(ArticleConstans.LOADTYPE_LOAD_NEW)){
            type=ArticleConstans.LOADTYPE_LOAD_MORE;
        }

        //判断用户是否登录
        //AppThreadLocalUtils.getUser()

        return null;
    }
}
