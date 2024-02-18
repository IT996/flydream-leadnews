package com.flydream.behavior.service.impl;

import com.flydream.model.behavior.dtos.ShowBehaviorDto;
import com.flydream.behavior.service.AppShowBehaviorService;
import com.flydream.model.behavior.pojos.ApBehaviorEntry;
import com.flydream.model.behavior.pojos.ApShowBehavior;
import com.flydream.model.mappers.app.ApBehaviorEntryMapper;
import com.flydream.model.common.dtos.ResponseResult;
import com.flydream.model.common.enums.AppHttpCodeEnum;
import com.flydream.model.mappers.app.ApShowBehaviorMapper;
import com.flydream.model.user.pojos.ApUser;
import com.flydream.utils.threadlocal.AppThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2024年02月18日 11:38
 */
@Service
@SuppressWarnings("all")
public class AppShowBehaviorServiceImpl implements AppShowBehaviorService {


    @Autowired
    private ApBehaviorEntryMapper apBehaviorEntryMapper;

    @Autowired
    private ApShowBehaviorMapper apShowBehaviorMapper;

    @Override
    public ResponseResult saveShowBehavior(ShowBehaviorDto dto) {
        //获取用户信息，获取设备ID
        ApUser user = AppThreadLocalUtils.getUser();
        //根据当前设备id或者用户信息查询行为实体 ap_behavior_entry
        if (user==null&&dto.getEquipmentId()==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Long userId=null;
        if (user!=null){
            userId=user.getId();
        }
        //查询用户 ,一个行为实体可能是用户或者设备
        ApBehaviorEntry apBehaviorEntry = apBehaviorEntryMapper.selectByUserIdOrEquipemntId(userId, dto.getEquipmentId());
        if (apBehaviorEntry==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //获取前台传递过来的文章列表id
        Integer[] articleIds = new Integer[dto.getArticleIds().size()];
        for (int i = 0; i < articleIds.length; i++) {
            articleIds[i]=dto.getArticleIds().get(i).getId();
        }
        //根据行为实体id和文章列表id查询app行为表  ap_show_behavior
        List<ApShowBehavior> apShowBehaviors = apShowBehaviorMapper.selectListByEntryIdAndArticleIds(apBehaviorEntry.getId(),articleIds);
        //数据过滤，需要删除表中已经存在的文章ID
        List<Integer> integers = Arrays.asList(articleIds);
        if (!apShowBehaviors.isEmpty()){
            apShowBehaviors.forEach(itemm->{
                Integer articleId = itemm.getArticleId();
                integers.remove(articleId);
            });
        }
        //保存操作
        if (!integers.isEmpty()){
            articleIds=new Integer[integers.size()];
            integers.toArray(articleIds);
            apShowBehaviorMapper.saveShowBehavior(articleIds,apBehaviorEntry.getId());
        }

        return ResponseResult.okResult(0);
    }
}
