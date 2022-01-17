package com.budget.template;


import com.budget.common.Request;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 14:39
 *
 * 模板执行接口抽象类
 */
public abstract class AbstractServiceCallback implements ServiceCallback {

    private final Request request;

    public AbstractServiceCallback(Request request) {
        this.request = request;
    }

    @Override
    public void check() {
        request.check();
    }
}
