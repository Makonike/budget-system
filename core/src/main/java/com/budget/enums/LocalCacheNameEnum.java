package com.budget.enums;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 15:47
 *
 * 本地缓存名称枚举
 */
public enum LocalCacheNameEnum {

    SYS_PARA_CACHE("SYS_PARA_CACHE", "系统参数配置缓存"),

    CUSTOM_SCHEME_CACHE("CUSTOM_SCHEME_CACHE", "自定义方案缓存"),
    ;

    /**
     * 缓存名称
     */
    private String cacheName;

    /**
     * 描述
     */
    private String desc;

    public String getCacheName() {
        return cacheName;
    }

    public String getDesc() {
        return desc;
    }

    LocalCacheNameEnum(String cacheName, String desc) {
        this.cacheName = cacheName;
        this.desc = desc;
    }

    public static LocalCacheNameEnum getEnumByCode(String name) {
        for (LocalCacheNameEnum cacheNameEnum : values()){
            if (cacheNameEnum.getCacheName().equals(name)){
                return cacheNameEnum;
            }
        }
        return null;
    }
}
