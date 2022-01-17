package com.budget.cache;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 14:39
 *
 * 本地缓存管理
 */
public interface LocalCacheManager {

    /**
     * 初始化缓存
     */
    void init();

    /**
     * 刷新缓存
     */
    void refresh();

    /**
     * 数据发生改变,通知刷新缓存
     * @param cacheName
     */
    boolean notifyRefresh(String cacheName);



}
