package com.budget.cache.impl;

import com.budget.cache.SystemParaLocalCache;
import com.budget.entitys.SysParaConf;
import com.budget.enums.LocalCacheNameEnum;
import com.budget.mapper.SysParaConfMapper;
import com.budget.util.CommonUtils;
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
public class SystemParaLocalCacheImpl extends AbstractLocalCache implements SystemParaLocalCache {

    private Map<String,SysParaConf> systemParaLocalCacheMap = new ConcurrentHashMap<>();

    @Resource
    private SysParaConfMapper sysParaConfMapper;

    @Override
    public SysParaConf getSysParaConfByCode(String sysCode) {
        systemParaLocalCacheMap.clear();
        if (CommonUtils.isBlank(systemParaLocalCacheMap)) {
            refreshContent(false);
        }
        return systemParaLocalCacheMap.get(sysCode);
    }

    @Override
    protected void refreshContent(boolean isEnforce) {
        if (!isEnforce && CommonUtils.isNotBlank(systemParaLocalCacheMap)) {
            return;
        }

        List<SysParaConf> allSysParaConfList = sysParaConfMapper.getAllSysParaConfList();
        if (CommonUtils.isBlank(allSysParaConfList)) {
            return;
        }

        for (SysParaConf sysParaConf : allSysParaConfList){
            systemParaLocalCacheMap.put(sysParaConf.getSysCode(),sysParaConf);
        }
    }

    @Override
    public String getCacheName() {
        return LocalCacheNameEnum.SYS_PARA_CACHE.getCacheName();
    }

    @Override
    public void clear() {
        systemParaLocalCacheMap.clear();
    }


}
