package com.flydream.model.behavior.dtos;

import com.flydream.model.annotation.IdEncrypt;
import com.flydream.model.article.pojos.ApArticle;
import lombok.Data;

import java.util.List;

/**
 * 功能描述 用户行为展示接收类
 *
 * @author: scott
 * @date: 2023年06月13日 9:10
 */
@Data
public class ShowBehaviorDto {
    //设备ID
    @IdEncrypt
    Integer equipmentId;
    List<ApArticle> articleIds;
}
