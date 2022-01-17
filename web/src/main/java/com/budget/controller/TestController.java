package com.budget.controller;

import com.budget.action.SchemeAction;
import com.budget.cache.LocalCacheManager;
import com.budget.cache.SystemParaLocalCache;
import com.budget.common.Result;
import com.budget.constant.CustomException;
import com.budget.entitys.SysParaConf;
import com.budget.enums.*;
import com.budget.factory.SchemeActionFactory;
import com.budget.model.SchemeActionModel;
import com.budget.model.SchemeContext;
import com.budget.model.SchemeModel;
import com.budget.request.SysParaConfReq;
import com.budget.service.CustomSchemeService;
import com.budget.service.SysParaConfService;
import com.budget.template.AbstractServiceCallback;
import com.budget.template.FacadeTemplate;
import com.budget.template.ServiceCallback;
import com.budget.util.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
public class TestController {

    @Resource
    private CustomSchemeService customSchemeService;

    @Resource
    private SysParaConfService sysParaConfService;

    @Resource
    private SchemeActionFactory schemeActionFactory;

    @Resource
    private LocalCacheManager localCacheManager;

    @GetMapping("/getSysParaConfByCode")
    @ResponseBody
    public Result<SysParaConf> getSysParaConfByCode(String sysCode) {
        Result<SysParaConf> result = new Result<>();
        FacadeTemplate.execute(result, new ServiceCallback() {

            @Override
            public void check() {
                if (CommonUtils.isBlank(sysCode)) {
                    throw new CustomException(ExceptionCodeEnum.PARAM_NOT_NULL);
                }
            }

            @Override
            public void execute() {
                SysParaConf sysParaConf = sysParaConfService.getSysParaConfByCode(sysCode);
                result.setResultObj(sysParaConf);
            }

            @Override
            public String getSceneName() {
                return SystemSceneEnum.GET_SYS_PARA_CONF.getCode();
            }

        });
        return result;
    }


    @PostMapping("/saveSysParaConf")
    @ResponseBody
    public Result<Void> saveSysParaConf(SysParaConfReq sysParaConfReq) {
        Result<Void> result = new Result<>();
        FacadeTemplate.execute(result, new AbstractServiceCallback(sysParaConfReq){

            @Override
            public void execute() {
                SysParaConf sysParaConf = new SysParaConf(sysParaConfReq.getSysCode(), sysParaConfReq.getSysVal(), sysParaConfReq.getMemo());
                sysParaConfService.saveSysParaConf(sysParaConf);

                //通知刷新本地缓存
                localCacheManager.notifyRefresh(LocalCacheNameEnum.SYS_PARA_CACHE.getCacheName());
            }

            @Override
            public String getSceneName() {
                return SystemSceneEnum.SAVE_SYS_PARA_CONF.getCode();
            }
        });
        return result;
    }


    /*@RequestMapping("/execute")
    @ResponseBody
    public void execute() {
        SchemeContext schemeContext = new SchemeContext(CustomSchemeCodeEnum.FOLLOW_UP_SCHEME,CustomProcessSceneEnum.QUES_STORE);

        SchemeModel schemeModel = customSchemeService.getSchemeModelByCode(schemeContext.getSchemeCodeEnum());

        schemeContext.setSchemeModel(schemeModel);

        for (SchemeActionModel actionModel : schemeContext.getCurrentActionList()){

            SchemeAction action = schemeActionFactory.getSchemeAction(actionModel.getActionEnum().getCode());
            if(CommonUtils.isBlank(action)){
                throw new CustomException(ExceptionCodeEnum.SCHEME_ACTION_NOT_EXIST);
            }
            action.execue(schemeContext);

            schemeContext.setCurrentSchemeActionModel(actionModel);
        }
    }*/

}
