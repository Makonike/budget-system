package com.budget.enums;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 15:47
 *
 * 自定义方案Code枚举
 */
public enum CustomSchemeCodeEnum {

    FOLLOW_UP_SCHEME("FOLLOW_UP_SCHEME", "随访方案"),

    ;

    /**
     * 方案编码
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

    CustomSchemeCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CustomSchemeCodeEnum getEnumByCode(String code) {
        for (CustomSchemeCodeEnum schemeCodeEnum : values()){
            if (schemeCodeEnum.getCode().equals(code)){
                return schemeCodeEnum;
            }
        }
        return null;
    }
}
