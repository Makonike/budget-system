package com.budget.config;

import com.budget.action.SchemeAction;
import com.budget.factory.SchemeActionFactory;
import com.budget.factory.impl.SchemeActionFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/29 22:24
 *
 * 自定义工厂配置类
 */
@Configuration
public class CustomFactoryConfig {

    @Bean
    public SchemeActionFactory schemeActionFactory(List<SchemeAction> actionList){
        Map<String,SchemeAction> actionMap = new HashMap<>();
        for (SchemeAction action:actionList) {
            actionMap.put(action.getActionName(),action);
        }
        return new SchemeActionFactoryImpl(actionMap);
    }

}
