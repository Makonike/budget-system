package com.budget.enums;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 15:47
 *
 * 场景名称枚举
 */
public enum SystemSceneEnum {

    GET_SYS_PARA_CONF("GET_SYS_PARA_CONF", "获取系统参数配置信息"),

    SAVE_SYS_PARA_CONF("SAVE_SYS_PARA_CONF", "保存系统参数配置信息"),

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

    SystemSceneEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SystemSceneEnum getEnumByCode(String code) {
        for (SystemSceneEnum sceneNameEnum : values()){
            if (sceneNameEnum.getCode().equals(code)){
                return sceneNameEnum;
            }
        }
        return null;
    }
}
