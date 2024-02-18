package com.flydream.model.behavior.dtos;

import com.flydream.model.annotation.IdEncrypt;
import com.flydream.model.article.pojos.ApArticle;
import lombok.Data;

import java.util.List;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2024年01月04日 14:38
 */
@Data
public class ShowBehaviorDto {
    // 设备ID
    @IdEncrypt
    Integer equipmentId;
    List<ApArticle> articleIds;
}
