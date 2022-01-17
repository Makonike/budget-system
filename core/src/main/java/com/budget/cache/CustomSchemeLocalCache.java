package com.budget.cache;

import com.budget.enums.CustomSchemeCodeEnum;
import com.budget.model.SchemeModel;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/27 0:05
 */
public interface CustomSchemeLocalCache {

    SchemeModel getSchemeByCode(CustomSchemeCodeEnum schemeCodeEnum);
}
