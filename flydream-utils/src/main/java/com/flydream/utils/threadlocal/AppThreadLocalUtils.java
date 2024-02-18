package com.flydream.utils.threadlocal;

import com.flydream.model.user.pojos.ApUser;

/**
 * 功能描述
 *
 * @author: scott
 * @date: 2024年01月04日 11:11
 */
public class AppThreadLocalUtils {

    private final  static ThreadLocal<ApUser> userThreadLocal = new ThreadLocal<>();

    /**
     * 设置当前线程中的用户
     * @param user
     */
    public static void setUser(ApUser user){
        userThreadLocal.set(user);
    }

    /**
     * 获取线程中的用户
     * @return
     */
    public static ApUser getUser( ){
        return userThreadLocal.get();
    }
}
