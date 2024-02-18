package com.flydream.model.behavior.pojos;

import lombok.Data;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2023年12月19日 11:05
 */
@Data
public class ApBehaviorEntry {
    private Integer id;
    private Short type;
    private Integer entryId;
    private Date createdTime;
    public String burst;

    /**
     * 这段代码定义了一个名为Type的枚举类型，其中包含两个枚举值：USER和EQUIPMENT。每个枚举值都有一个对应的短整型数值（code），
     * 分别被赋值为1和0。同时，还定义了一个名为Getter的方法，用于获取枚举值的code属性。
     */
    @Alias("ApBehaviorEntryEnumType")
    public enum  Type{
        USER((short)1),EQUIPMENT((short)0);
        @Getter
        short code;
        Type(short code){
            this.code = code;
        }
    }

    /**
     * 这段代码是一个Java方法，名为isUser。它的作用是判断当前对象的类型是否为用户类型（Type.USER）。
     *
     * 方法的实现逻辑如下：
     *
     * 首先，通过调用this.getType()获取当前对象的类型。
     * 然后，检查获取到的类型是否不为null且等于用户类型的代码（Type.USER.getCode()）。
     * 如果满足上述条件，说明当前对象是用户类型，返回true。
     * 如果不满足条件，则返回false。
     * @return
     */
    public boolean isUser(){
        if(this.getType()!=null&&this.getType()== Type.USER.getCode()){
            return true;
        }
        return false;
    }
}
