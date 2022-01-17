package com.budget.entitys;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/26 21:19
 *
 * 缓存管理实体
 */
public class CacheManage implements Serializable {

    private static final long serialVersionUID = -5810531410138640659L;

    //缓存ID
    private Long cacheId;

    //缓存名称
    private String cacheName;

    //ip地址
    private String serverIp;

    //LocalCacheStatusEcum-缓存状态:初始化INITIAL、待刷新WAIT_REFRESH、刷新完成REFRESH_COMPLETE
    private String status;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

    public Long getCacheId() {
        return cacheId;
    }

    public void setCacheId(Long cacheId) {
        this.cacheId = cacheId;
    }

    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public CacheManage(String cacheName, String serverIp, String status) {
        this.cacheName = cacheName;
        this.serverIp = serverIp;
        this.status = status;
    }

    public CacheManage() {}
}
