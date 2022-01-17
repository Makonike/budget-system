package com.budget.cache;

import com.budget.entitys.SysParaConf;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/27 0:05
 */
public interface SystemParaLocalCache {

    /**
     * 根据系统配置code获取系统配置详情
     * @param sysCode 系统code
     * @return
     */
    SysParaConf getSysParaConfByCode(String sysCode);

}
