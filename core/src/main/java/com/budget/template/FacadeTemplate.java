package com.budget.template;

import com.budget.common.Result;
import com.budget.constant.CustomException;
import com.budget.enums.ExceptionCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 14:39
 *
 * 执行模板
 */
public class FacadeTemplate {

    private static final Logger logger = LoggerFactory.getLogger(FacadeTemplate.class);

    public static <T> void execute(Result<T> result, ServiceCallback serviceCallBack){
        try{
            serviceCallBack.check();
            serviceCallBack.execute();
            result.setSuccess(true);
        }catch(CustomException e){
            logger.error("系统执行出错,错误码:{},错误描述:{}",e.getExceptionEnum().getCode(),e.getExceptionEnum().getDesc());
            result.setCode(e.getExceptionEnum().getCode());
            result.setMessage(e.getExceptionEnum().getDesc());
            result.setSuccess(false);
        }catch(Exception e){
            e.printStackTrace();
            logger.error("系统执行出错,请联系管理员！错误信息:{}",e.getMessage());
            result.setCode(ExceptionCodeEnum.SYSTEM_ERROR.getCode());
            result.setMessage(ExceptionCodeEnum.SYSTEM_ERROR.getDesc()+"错误信息:"+e.getMessage());
            result.setSuccess(false);
        }
    }


}
