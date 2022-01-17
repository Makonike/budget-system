package com.budget.enums;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 15:47
 *
 * 自定义流程-Action枚举
 */
public enum CustomProcessActionEnum {

    QUES_STORE_ACTION("QUES_STORE_ACTION", "随访方案-落库"),

    QUES_SEND_MSG_ACTION("QUES_SEND_MSG_ACTION", "随访方案-消息发送"),

    QUES_FEEDBACK_ACTION("QUES_FEEDBACK_ACTION", "随访方案-填写反馈"),

    ;

    /**
     * action_code
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

    CustomProcessActionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CustomProcessActionEnum getEnumByCode(String code) {
        for (CustomProcessActionEnum actionEnum : values()){
            if (actionEnum.getCode().equals(code)){
                return actionEnum;
            }
        }
        return null;
    }
}
