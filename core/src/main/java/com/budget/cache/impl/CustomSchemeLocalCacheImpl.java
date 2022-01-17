package com.budget.cache.impl;

import com.budget.cache.CustomSchemeLocalCache;
import com.budget.entitys.CustomScheme;
import com.budget.enums.CustomProcessActionEnum;
import com.budget.enums.CustomProcessSceneEnum;
import com.budget.enums.CustomSchemeCodeEnum;
import com.budget.enums.LocalCacheNameEnum;
import com.budget.mapper.CustomSchemeMapper;
import com.budget.model.SchemeActionModel;
import com.budget.model.SchemeModel;
import com.budget.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/27 0:06
 */
@Component
public class CustomSchemeLocalCacheImpl extends AbstractLocalCache implements CustomSchemeLocalCache {

    private static final Logger logger = LoggerFactory.getLogger(CustomSchemeLocalCacheImpl.class);

    /** key:方案code,val:方案场景model */
    private Map<String,SchemeModel> schemeLocalCacheMap = new ConcurrentHashMap<>();

    @Resource
    private CustomSchemeMapper customSchemeMapper;

    @Override
    public SchemeModel getSchemeByCode(CustomSchemeCodeEnum schemeCodeEnum) {
        if (CommonUtils.isBlank(schemeLocalCacheMap)) {
            refreshContent(false);
        }
        return schemeLocalCacheMap.get(schemeCodeEnum.getCode());
    }

    @Override
    protected void refreshContent(boolean isEnforce) {
        if (!isEnforce && CommonUtils.isNotBlank(schemeLocalCacheMap)) {
            return;
        }

        List<CustomScheme> schemeList = customSchemeMapper.getAllCustomScheme();
        if (CommonUtils.isBlank(schemeList)) {
            return;
        }

        if (CommonUtils.isBlank(schemeLocalCacheMap)) {
            schemeLocalCacheMap = new ConcurrentHashMap<>();
        }

        for (CustomScheme scheme : schemeList) {

            CustomSchemeCodeEnum schemeEnum = CustomSchemeCodeEnum.getEnumByCode(scheme.getSchemeCode());
            CustomProcessSceneEnum sceneEnum = CustomProcessSceneEnum.getEnumByCode(scheme.getProcessScene());
            CustomProcessActionEnum actionEnum = CustomProcessActionEnum.getEnumByCode(scheme.getProcessAction());

            if (CommonUtils.isBlank(schemeEnum) || CommonUtils.isBlank(sceneEnum) || CommonUtils.isBlank(actionEnum)) {
                logger.warn("自定义方案配置枚举有误");
                continue;
            }

            if (!schemeLocalCacheMap.containsKey(scheme.getSchemeCode())) {
                schemeLocalCacheMap.put(scheme.getSchemeCode(), new SchemeModel(schemeEnum));
            }

            SchemeActionModel actionModel = new SchemeActionModel(actionEnum, scheme.getActionParam(), scheme.getActionOrder(), scheme.getMemo());
            schemeLocalCacheMap.get(scheme.getSchemeCode()).addProcessAction( sceneEnum, actionModel);
        }
    }

    @Override
    public String getCacheName() {
        return LocalCacheNameEnum.CUSTOM_SCHEME_CACHE.getCacheName();
    }

    @Override
    public void clear() {
        schemeLocalCacheMap.clear();
    }



}
