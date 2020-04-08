package com.yuntian.helloworld.condition;

/**
 * @author guangleilei.
 * @date Created in 15:29 2019/10/22
 * @description Windows系统的判断条件
 */
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("os.name").contains("Windows");
    }
}



