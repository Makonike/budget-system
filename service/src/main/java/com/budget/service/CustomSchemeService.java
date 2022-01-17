package com.budget.service;


import com.budget.enums.CustomSchemeCodeEnum;
import com.budget.model.SchemeModel;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 13:02
 * 自定义方案Service
 */
public interface CustomSchemeService {

    /**
     * 通过方案Enum获取方案实体
     * @param schemeCodeEnum
     * @return
     */
    SchemeModel getSchemeModelByCode(CustomSchemeCodeEnum schemeCodeEnum);
}
