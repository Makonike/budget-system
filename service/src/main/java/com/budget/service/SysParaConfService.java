package com.budget.service;


import com.budget.entitys.SysParaConf;
import com.budget.enums.CustomSchemeCodeEnum;
import com.budget.model.SchemeModel;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 13:02
 *
 * 系统参数配置Service
 */
public interface SysParaConfService {

    SysParaConf getSysParaConfByCode(String sysCode);

    void saveSysParaConf(SysParaConf sysParaConf);
}
