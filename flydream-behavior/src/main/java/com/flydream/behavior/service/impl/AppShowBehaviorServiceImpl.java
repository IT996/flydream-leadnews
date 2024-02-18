package com.flydream.behavior.service.impl;

import com.flydream.model.behavior.dtos.ShowBehaviorDto;
import com.flydream.behavior.service.AppShowBehaviorService;
import com.flydream.model.mappers.app.ApBehaviorEntryMapper;
import com.flydream.model.common.dtos.ResponseResult;
import com.flydream.model.common.enums.AppHttpCodeEnum;
import com.flydream.model.user.pojos.ApUser;
import com.flydream.utils.threadlocal.AppThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


        return null;
    }
}
