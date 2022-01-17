package com.budget.cache.impl;


import com.budget.cache.LocalCache;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 14:39
 *
 * 抽象本地缓存接口
 */
public abstract class AbstractLocalCache implements LocalCache {

    /**
     * 刷新缓存
     * @param isEnforce 是否强制刷新:ture是,false否
     */
    @Override
    public void refresh(boolean isEnforce) {
        synchronized (this) {
            refreshContent(isEnforce);
        }
    }

    /**
     * @param isEnforce 是否强制刷新:ture是,false否
     * 强制刷新:直接刷新,非强制刷新:缓存存在数据即不刷新
     */
    protected abstract void refreshContent(boolean isEnforce);

}
