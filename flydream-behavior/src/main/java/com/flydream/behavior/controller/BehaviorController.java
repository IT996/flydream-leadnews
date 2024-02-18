package com.flydream.behavior.controller;

import com.flydream.article.apis.BehaviorControllerApi;
import com.flydream.model.behavior.dtos.ShowBehaviorDto;
import com.flydream.behavior.service.AppShowBehaviorService;
import com.flydream.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2024年02月18日 11:25
 */
@RestController
@RequestMapping("/api/behavior")
public class BehaviorController implements BehaviorControllerApi {

    @Autowired
    private AppShowBehaviorService appShowBehaviorService;

    @Override
    @PostMapping("/show_behavior")
    public ResponseResult saveShowBehavior(@RequestBody ShowBehaviorDto dto) {
        return appShowBehaviorService.saveShowBehavior(dto);
    }
}
