package com.budget.common;

import java.io.Serializable;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 14:39
 *
 * 请求实体抽象类
 */
public abstract class Request implements Serializable {

    private static final long serialVersionUID = -1163893939732210349L;

    public abstract boolean check();
}
