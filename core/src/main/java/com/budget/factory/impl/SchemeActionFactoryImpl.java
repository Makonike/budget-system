package com.budget.factory.impl;

import com.budget.action.SchemeAction;
import com.budget.factory.SchemeActionFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SchemeActionFactoryImpl implements SchemeActionFactory {

    private Map<String,SchemeAction> actionMap = new HashMap<>();

    public SchemeActionFactoryImpl(Map<String, SchemeAction> actionMap) {
        this.actionMap = actionMap;
    }

    @Override
    public SchemeAction getSchemeAction(String actionName) {
        return actionMap.get(actionName);
    }
}
