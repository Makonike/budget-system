package com.budget.factory;

import com.budget.action.SchemeAction;

public interface SchemeActionFactory {

    /**
     * 获取处理器执行
     * @param actionName
     * @return
     */
    SchemeAction getSchemeAction(String actionName);

}
