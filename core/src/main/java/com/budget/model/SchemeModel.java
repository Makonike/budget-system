package com.budget.model;

import com.budget.enums.CustomProcessSceneEnum;
import com.budget.enums.CustomSchemeCodeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/29 22:24
 */
public class SchemeModel {

    /**
     * 方案code
     */
    private CustomSchemeCodeEnum schemeCodeEnum;

    /**
     * key:场景,value:场景对应action
     */
    private Map<CustomProcessSceneEnum,List<SchemeActionModel>> processActionMap = new HashMap<>();

    public CustomSchemeCodeEnum getSchemeCodeEnum() {
        return schemeCodeEnum;
    }

    public void setSchemeCodeEnum(CustomSchemeCodeEnum schemeCodeEnum) {
        this.schemeCodeEnum = schemeCodeEnum;
    }

    public Map<CustomProcessSceneEnum, List<SchemeActionModel>> getProcessActionMap() {
        return processActionMap;
    }

    public void setProcessActionMap(Map<CustomProcessSceneEnum, List<SchemeActionModel>> processActionMap) {
        this.processActionMap = processActionMap;
    }

    public SchemeModel() {
    }

    public SchemeModel(CustomSchemeCodeEnum schemeCodeEnum) {
        this.schemeCodeEnum = schemeCodeEnum;
    }

    public void addProcessAction(CustomProcessSceneEnum sceneEnum,SchemeActionModel actionModel) {
        if(!processActionMap.containsKey(sceneEnum)){
            processActionMap.put(sceneEnum,new ArrayList<>());
        }
        processActionMap.get(sceneEnum).add(actionModel);
    }

}
