package com.budget.model;

import com.budget.enums.CustomProcessSceneEnum;
import com.budget.enums.CustomSchemeCodeEnum;
import com.budget.util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/29 22:24
 *
 * 自定义方案上下文
 */
public class SchemeContext {

    //方案
    private CustomSchemeCodeEnum schemeCodeEnum;

    //全部方案
    private SchemeModel schemeModel;

    //当前场景
    private CustomProcessSceneEnum currentProcessSceneEnum;

    //当前动作
    private SchemeActionModel currentSchemeActionModel;

    public CustomSchemeCodeEnum getSchemeCodeEnum() {
        return schemeCodeEnum;
    }

    public void setSchemeCodeEnum(CustomSchemeCodeEnum schemeCodeEnum) {
        this.schemeCodeEnum = schemeCodeEnum;
    }

    public SchemeModel getSchemeModel() {
        return schemeModel;
    }

    public void setSchemeModel(SchemeModel schemeModel) {
        this.schemeModel = schemeModel;
    }

    public CustomProcessSceneEnum getCurrentProcessSceneEnum() {
        return currentProcessSceneEnum;
    }

    public void setCurrentProcessSceneEnum(CustomProcessSceneEnum currentProcessSceneEnum) {
        this.currentProcessSceneEnum = currentProcessSceneEnum;
    }

    public SchemeActionModel getCurrentSchemeActionModel() {
        return currentSchemeActionModel;
    }

    public void setCurrentSchemeActionModel(SchemeActionModel currentSchemeActionModel) {
        this.currentSchemeActionModel = currentSchemeActionModel;
    }

    public SchemeContext(CustomSchemeCodeEnum schemeCodeEnum, CustomProcessSceneEnum currentProcessSceneEnum) {
        this.schemeCodeEnum = schemeCodeEnum;
        this.currentProcessSceneEnum = currentProcessSceneEnum;
    }

    public List<SchemeActionModel> getCurrentActionList() {
        if(CommonUtils.isBlank(schemeModel)){
            return new ArrayList<>();
        }
        List<SchemeActionModel> actionModels = schemeModel.getProcessActionMap().get(currentProcessSceneEnum);
        return null == actionModels ? new ArrayList<>() : actionModels;
    }
}
