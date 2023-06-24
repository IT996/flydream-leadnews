package com.flydream.model.mappers.app;

import com.flydream.model.behavior.pojos.ApShowBehavior;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApShowBehaviorMapper {

    /**
     * 获取以及存在的用户数据
     * @param id
     * @param articleIds
     * @return
     */
    List<ApShowBehavior> selectListByEntryIdAndArticleIds(@Param("entryId") Integer id, @Param("articleIds")Integer[] articleIds);


    /**
     * 保存用户展现行为数据
     * @param temp 文章IDS
     * @param id 实体ID
     */
    void saveShowBehavior(@Param("articleIds") Integer[] temp, @Param("entryId") Integer id);
}
