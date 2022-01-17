package com.budget.service.impl;

import com.budget.cache.SystemParaLocalCache;
import com.budget.entitys.SysParaConf;
import com.budget.mapper.SysParaConfMapper;
import com.budget.service.SysParaConfService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 13:03
 */
@Service
public class SysParaConfServiceImpl implements SysParaConfService {

    @Resource
    private SysParaConfMapper sysParaConfMapper;

    @Resource
    private SystemParaLocalCache systemParaLocalCache;

    @Override
    public SysParaConf getSysParaConfByCode(String sysCode) {
        return systemParaLocalCache.getSysParaConfByCode(sysCode);
    }

    @Override
    public void saveSysParaConf(SysParaConf sysParaConf) {
        sysParaConfMapper.saveSysParaConf(sysParaConf);
    }


}
