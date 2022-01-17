package com.budget.cache;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 14:39
 *
 * 本地缓存接口
 */
public interface LocalCache {

    /**
     * 刷新缓存
     * 强制刷新:直接刷新,非强制刷新:缓存存在数据即不刷新
     *
     * @param isEnforce 是否强制刷新:ture是,false否
     */
    void refresh(boolean isEnforce);

    /**
     * 获取缓存名称
     */
    String getCacheName();


    /**
     * 清除缓存
     */
    void clear();
}
