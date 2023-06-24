package com.flydream.behavior.service.impl;

import com.flydream.behavior.service.AppShowBehaviorService;
import com.flydream.common.zookeeper.sequence.Sequences;
import com.flydream.model.behavior.dtos.ShowBehaviorDto;
import com.flydream.model.behavior.pojos.ApBehaviorEntry;
import com.flydream.model.behavior.pojos.ApShowBehavior;
import com.flydream.model.common.dtos.ResponseResult;
import com.flydream.model.common.enums.AppHttpCodeEnum;
import com.flydream.model.mappers.app.ApBehaviorEntryMapper;
import com.flydream.model.mappers.app.ApShowBehaviorMapper;
import com.flydream.model.user.pojos.ApUser;
import com.flydream.utils.threadlocal.AppThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2023年06月13日 15:40
 */
@Service
@SuppressWarnings("all")
public class AppShowBehaviorServiceImpl implements AppShowBehaviorService {


    @Autowired
    private ApBehaviorEntryMapper apBehaviorEntryMapper;
    @Autowired
    private ApShowBehaviorMapper apShowBehaviorMapper;

    @Autowired
    private Sequences sequences;

    @Override
    public ResponseResult saveShowBehavior(ShowBehaviorDto dto) {
        ApUser user = AppThreadLocalUtils.getUser();
        //用户和设备不能同时为空
        //根据当前的用户信息或设备id查询行为实体 ap_behavior_entry
        if(user==null&&(dto.getArticleIds()==null||dto.getArticleIds().isEmpty())){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Long userId=null;
        if (user!=null){
            userId=user.getId();
        }
        //查询用户登录的设备或用户信息
        ApBehaviorEntry apBehaviorEntry = apBehaviorEntryMapper.selectByUserIdOrEquipemntId(userId, dto.getEquipmentId());
        // 行为实体找以及注册了，逻辑上这里是必定有值得，除非参数错误
        if (apBehaviorEntry==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        // 过滤新数据
        //获取前台传递过来的文章列表id
        Integer[] articleIds = new Integer[dto.getArticleIds().size()];
        for (int i = 0; i < articleIds.length; i++) {
            articleIds[i]=dto.getArticleIds().get(i).getId();
        }
        //根据行为实体id和文章列表id查询app行为表  ap_show_behavior
        List<ApShowBehavior> lists = apShowBehaviorMapper.selectListByEntryIdAndArticleIds(apBehaviorEntry.getId(), articleIds);

        ArrayList<Integer> stringList = new ArrayList<>(Arrays.asList(articleIds));
        //数据的过滤，需要删除表中已经存在的文章id
        if (!stringList.isEmpty()){
            lists.forEach(item->{
                Integer articleId = item.getArticleId();
                stringList.remove(articleId);
            });
        }
        //保存操作
        if (!stringList.isEmpty()){
            articleIds = new Integer[stringList.size()];
            stringList.toArray(articleIds);
            apShowBehaviorMapper.saveShowBehavior(articleIds,apBehaviorEntry.getId());
        }
        return ResponseResult.okResult(0);
    }
}
