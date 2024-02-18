package com.flydream.model.mappers.app;

import com.flydream.model.behavior.pojos.ApBehaviorEntry;
import org.apache.ibatis.annotations.Param;

public interface ApBehaviorEntryMapper {
    ApBehaviorEntry selectByUserIdOrEquipemntId(@Param("userId") Long userId, @Param("equipmentId") Integer equipmentId);
}
