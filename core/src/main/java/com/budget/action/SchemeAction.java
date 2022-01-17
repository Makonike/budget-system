package com.budget.action;

import com.budget.model.SchemeContext;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/29 22:24
 *
 * 方案流程action
 */
public interface SchemeAction {

    /**
     * 执行处理器
     * @param schemeContext 方案上下文
     */
    void execue(SchemeContext schemeContext);

    /**
     * 获取处理器名称
     * @return
     */
    String getActionName();

}
