package com.flydream.behavior.apis;

import com.flydream.model.behavior.dtos.ShowBehaviorDto;
import com.flydream.model.common.dtos.ResponseResult;

public interface BehaviorControllerApi {

    /**
     * 保存用户点击文章行为
     * @param dto
     * @return
     */
    ResponseResult saveShowBehavior(ShowBehaviorDto dto);
}
