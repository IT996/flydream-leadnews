package com.flydream.article.apis;

import com.flydream.model.behavior.dtos.ShowBehaviorDto;
import com.flydream.model.common.dtos.ResponseResult;


public interface BehaviorControllerApi {
    /**
     * 记录用户行为
     * @param bto
     * @return
     */
    ResponseResult saveShowBehavior(ShowBehaviorDto bto);
}
