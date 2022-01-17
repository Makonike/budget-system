package com.budget.constant;


import com.budget.enums.ExceptionCodeEnum;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 15:37
 *
 * 自定义异常
 */
public class CustomException extends RuntimeException{

    private ExceptionCodeEnum exceptionEnum;

    public CustomException(ExceptionCodeEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.exceptionEnum = exceptionEnum;
    }

    public CustomException(ExceptionCodeEnum exceptionEnum, Throwable cause) {
        super(exceptionEnum.getMessage(), cause);
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionCodeEnum getExceptionEnum() {
        return exceptionEnum;
    }

}
