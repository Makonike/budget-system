package com.budget.enums;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 15:47
 *
 * 自定义流程场景枚举
 */
public enum CustomProcessSceneEnum {

    QUES_STORE("QUES_STORE", "问卷-落库"),

    QUES_SEND("QUES_SEND", "问卷-发送"),

    QUES_FEEDBACK("QUES_FEEDBACK", "问卷-填写"),

    ;

    /**
     * 流程编码
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

    CustomProcessSceneEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CustomProcessSceneEnum getEnumByCode(String code) {
        for (CustomProcessSceneEnum sceneEnum : values()){
            if (sceneEnum.getCode().equals(code)){
                return sceneEnum;
            }
        }
        return null;
    }
}
