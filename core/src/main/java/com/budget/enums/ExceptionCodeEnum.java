package com.budget.enums;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 15:47
 *
 * 异常响应码枚举
 */
public enum ExceptionCodeEnum {

    SYSTEM_ERROR("SYSTEM_ERROR", "系统错误,请联系管理员"),

    INIT_CACHE_ERROR("INIT_CACHE_ERROR", "初始化缓存失败"),

    REFRESH_CACHE_ERROR("REFRESH_CACHE_ERROR", "定时刷新缓存失败"),

    NOTIFY_REFRESH_CACHE_ERROR("NOTIFY_REFRESH_CACHE_ERROR", "通知刷新缓存失败"),

    SCHEME_ACTION_NOT_EXIST("SCHEME_ACTION_NOT_EXIST", "系统错误,执行处理器不存在"),

    PARAM_NOT_NULL("PARAM_NOT_NULL", "参数不能为空"),

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

    ExceptionCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ExceptionCodeEnum getEnumByCode(String code) {
        for (ExceptionCodeEnum exceptionEnum : values()){
            if (exceptionEnum.getCode().equals(code)){
                return exceptionEnum;
            }
        }
        return null;
    }

    public String getMessage(){
        return "code = " + code + ", desc = " + desc;
    }
}
