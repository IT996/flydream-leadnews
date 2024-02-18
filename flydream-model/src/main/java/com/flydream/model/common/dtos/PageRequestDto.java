package com.flydream.model.common.dtos;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2023年12月11日 13:56
 */
@Data
@Slf4j
public class PageRequestDto {
    protected Integer size;
    protected Integer page;

    public void checkParam(){
        if (this.page==null || this.page<0){
            setPage(1);
        }
        if (this.size==null || this.size<0 ||this.size>100){
            setSize(10);
        }
    }
}