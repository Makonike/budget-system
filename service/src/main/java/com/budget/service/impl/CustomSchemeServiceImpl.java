package com.budget.service.impl;

import com.budget.cache.CustomSchemeLocalCache;
import com.budget.enums.CustomSchemeCodeEnum;
import com.budget.mapper.CustomSchemeMapper;
import com.budget.model.SchemeModel;
import com.budget.service.CustomSchemeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 13:03
 */
@Service
public class CustomSchemeServiceImpl implements CustomSchemeService {

    @Resource
    private CustomSchemeMapper customSchemeMapper;

    @Resource
    private CustomSchemeLocalCache customSchemeLocalCache;
    
    @Override
    public SchemeModel getSchemeModelByCode(CustomSchemeCodeEnum schemeCodeEnum) {
        return customSchemeLocalCache.getSchemeByCode(schemeCodeEnum);
    }

}
