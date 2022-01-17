package com.budget.model;


import com.budget.enums.CustomProcessActionEnum;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/29 22:24
 */
public class SchemeActionModel {

    //流程action
    private CustomProcessActionEnum actionEnum;

    //action参数
    private String actionParam;

    //action顺序
    private String actionOrder;

    //备注
    private String memo;

    public CustomProcessActionEnum getActionEnum() {
        return actionEnum;
    }

    public void setActionEnum(CustomProcessActionEnum actionEnum) {
        this.actionEnum = actionEnum;
    }

    public String getActionParam() {
        return actionParam;
    }

    public void setActionParam(String actionParam) {
        this.actionParam = actionParam;
    }

    public String getActionOrder() {
        return actionOrder;
    }

    public void setActionOrder(String actionOrder) {
        this.actionOrder = actionOrder;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public SchemeActionModel() {
    }

    public SchemeActionModel(CustomProcessActionEnum actionEnum, String actionParam, String actionOrder, String memo) {
        this.actionEnum = actionEnum;
        this.actionParam = actionParam;
        this.actionOrder = actionOrder;
        this.memo = memo;
    }
}
