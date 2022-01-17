package com.budget.cache.impl;

import com.budget.cache.LocalCache;
import com.budget.cache.LocalCacheManager;
import com.budget.constant.CustomException;
import com.budget.entitys.CacheManage;
import com.budget.enums.ExceptionCodeEnum;
import com.budget.enums.LocalCacheStatusEnum;
import com.budget.mapper.CacheManageMapper;
import com.budget.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 14:39
 *
 * 本地缓存管理实现
 */
@Component
public class LocalCacheManagerImpl implements LocalCacheManager {

    private static final Logger logger = LoggerFactory.getLogger(LocalCacheManagerImpl.class);

    @Resource
    private List<LocalCache> localCacheList = new ArrayList<>();

    @Resource
    private CacheManageMapper cacheManageMapper;

    @Value("${server.ip}")
    private String serverIp;

    @Override
    @PostConstruct
    public void init() {
        logger.info("系统启动,开始初始化缓存");

        for (LocalCache localCache : localCacheList) {

            CacheManage cacheManage = cacheManageMapper.getCacheManageByCond(serverIp, localCache.getCacheName());
            if (CommonUtils.isBlank(cacheManage)) {
                cacheManage = new CacheManage();
                cacheManage.setServerIp(serverIp);
                cacheManage.setCacheName(localCache.getCacheName());
                cacheManage.setStatus(LocalCacheStatusEnum.INITIAL.getCode());
                cacheManageMapper.insertCacheManage(cacheManage);
            } else {
                cacheManageMapper.updateStatusById(cacheManage.getCacheId(), LocalCacheStatusEnum.INITIAL.getCode());
            }

            try {
                localCache.refresh(true);
                cacheManageMapper.updateStatusById(cacheManage.getCacheId(), LocalCacheStatusEnum.REFRESH_COMPLETE.getCode());
            } catch (Throwable cause) {
                logger.error("系统启动,初始化缓存失败");
                throw new CustomException(ExceptionCodeEnum.INIT_CACHE_ERROR, cause);
            }
        }

        logger.info("系统启动,初始化缓存完成");
    }

    @Override
    @Scheduled(cron = "0 */1 * * * ?")
    public void refresh() {
        logger.info("本地缓存刷新-定时任务开始");

        for (LocalCache localCache : localCacheList) {
            logger.info("开始刷新本地缓存,缓存名称:{},ip:{}", localCache.getCacheName(), serverIp);

            CacheManage cacheManage = cacheManageMapper.getCacheManageByStatus(serverIp,localCache.getCacheName(), LocalCacheStatusEnum.WAIT_FOR_REFRESH.getCode());
            if (CommonUtils.isBlank(cacheManage)) {
                logger.info("本地缓存无需刷新,缓存名称:{},ip:{}", localCache.getCacheName(), serverIp);
                continue;
            }
            try {
                localCache.refresh(true);

                cacheManageMapper.updateStatusById(cacheManage.getCacheId(), LocalCacheStatusEnum.REFRESH_COMPLETE.getCode());

                logger.info("刷新本地缓存完成,缓存名称:{},ip:{}", localCache.getCacheName(), serverIp);
            } catch (Throwable cause) {
                logger.error("本地缓存刷新失败,缓存名称:{},ip:{}", localCache.getCacheName(), serverIp, cause);
            }
        }

        logger.info("本地缓存刷新-定时任务结束");
    }

    @Override
    public boolean notifyRefresh(String cacheName) {
        logger.info("接收通知更新缓存,更新缓存状态为待刷新,缓存名称:{}", cacheName);
        if (CommonUtils.isBlank(cacheName)) {
            logger.error("接收通知更新缓存,更新缓存状态为待刷新失败,缓存名称不能为空");
            return false;
        }
        int count = cacheManageMapper.updateStatusByName(cacheName, LocalCacheStatusEnum.WAIT_FOR_REFRESH.getCode());
        if (count==0) {
            logger.error("接收通知更新缓存,更新缓存状态为待刷新失败,更新记录为0");
            throw new CustomException(ExceptionCodeEnum.NOTIFY_REFRESH_CACHE_ERROR);
        }
        return true;
    }

}
