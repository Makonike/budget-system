package com.budget.enums;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 15:47
 *
 * 本地缓存状态枚举
 */
public enum LocalCacheStatusEnum {

    INITIAL("INITIAL", "初始化"),

    WAIT_FOR_REFRESH("WAIT_FOR_REFRESH", "等待刷新"),

    REFRESH_COMPLETE("REFRESH_COMPLETE", "刷新完成"),
    ;

    /**
     * 编码
     */
    private String code;

    /**
     * 描述
     */
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    LocalCacheStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static LocalCacheStatusEnum getEnumByCode(String code) {
        for (LocalCacheStatusEnum cacheStatusEnum : values()){
            if (cacheStatusEnum.getCode().equals(code)){
                return cacheStatusEnum;
            }
        }
        return null;
    }
}
