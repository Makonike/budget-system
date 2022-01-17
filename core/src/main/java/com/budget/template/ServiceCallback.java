package com.budget.template;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 14:39
 *
 * 模板执行接口
 */
public interface ServiceCallback {

    /**
     * 检查参数
     */
    void check();

    /**
     * 执行方法
     */
    void execute();

    /**
     * 获取执行场景
     */
    String getSceneName();

}
