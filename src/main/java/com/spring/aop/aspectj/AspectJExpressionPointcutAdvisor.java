package com.spring.aop.aspectj;

import com.spring.aop.PointCut;
import com.spring.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @author zhangqingyang
 * @date 2022-07-11-20:20
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointCut pointCut;
    private Advice advice;
    private String expression;


    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public PointCut getPointcut() {
        if (pointCut == null) {
            pointCut = new AspectJExpressionPointCut(expression);
        }
        return pointCut;
    }
}
