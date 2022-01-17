package com.budget.action.impl;

import com.budget.action.SchemeAction;
import com.budget.enums.CustomProcessActionEnum;
import com.budget.model.SchemeContext;
import org.springframework.stereotype.Component;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/30 23:50
 *
 * 随访方案-填写反馈action
 */
@Component
public class QuesFeedbackAction implements SchemeAction {

    @Override
    public void execue(SchemeContext schemeContext) {

    }

    @Override
    public String getActionName() {
        return CustomProcessActionEnum.QUES_FEEDBACK_ACTION.getCode();
    }

}
