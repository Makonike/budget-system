package com.budget.request;

import com.budget.common.Request;
import com.budget.constant.CustomException;
import com.budget.enums.ExceptionCodeEnum;
import com.budget.util.CommonUtils;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 13:28
 *
 * 系统参数配置请求实体
 */
public class SysParaConfReq extends Request {

    //系统code
    private String sysCode;

    //系统val
    private String sysVal;

    //备注
    private String memo;

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getSysVal() {
        return sysVal;
    }

    public void setSysVal(String sysVal) {
        this.sysVal = sysVal;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public boolean check() {
        if (CommonUtils.isBlank(sysCode) || CommonUtils.isBlank(sysVal)) {
            throw new CustomException(ExceptionCodeEnum.PARAM_NOT_NULL);
        }
        return true;
    }
}
