package com.budget.entitys;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/28 23:35
 *
 * 自定义流程方案实体
 */
public class CustomScheme implements Serializable {

    private static final long serialVersionUID = 5280623646938536091L;

    //主键id
    private Long schemeId;

    //CustomSchemeCodeEnum-标识整个方案,方案code
    private String schemeCode;

    //CustomProcessSceneEnum-流程场景
    private String processScene;

    //CustomProcessActionEnum-流程action
    private String processAction;

    //action参数
    private String actionParam;

    //action顺序
    private String actionOrder;

    //备注
    private String memo;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

    public Long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getProcessScene() {
        return processScene;
    }

    public void setProcessScene(String processScene) {
        this.processScene = processScene;
    }

    public String getProcessAction() {
        return processAction;
    }

    public void setProcessAction(String processAction) {
        this.processAction = processAction;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
