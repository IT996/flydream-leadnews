package com.flydream.behavior.service;

import com.flydream.model.behavior.dtos.ShowBehaviorDto;
import com.flydream.model.common.dtos.ResponseResult;

public interface AppShowBehaviorService {

    /**
     * 存储用户行为数据
     * @param dto
     * @return
     */
    ResponseResult saveShowBehavior(ShowBehaviorDto dto);
}
