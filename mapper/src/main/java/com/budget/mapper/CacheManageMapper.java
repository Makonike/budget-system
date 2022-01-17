package com.budget.mapper;

import com.budget.entitys.CacheManage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 13:30
 */
@Mapper
public interface CacheManageMapper {

    CacheManage getCacheManageByCond(@Param("serverIp") String serverIp, @Param("cacheName") String cacheName);

    void updateStatusById(@Param("cacheId") Long cacheId,@Param("status") String status);

    void insertCacheManage(CacheManage cacheManage);

    CacheManage getCacheManageByStatus(@Param("serverIp") String serverIp,@Param("cacheName") String cacheName,@Param("status") String status);

    int updateStatusByName(@Param("cacheName") String cacheName,@Param("status") String status);
}
