package com.sonan.booklibrary.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * spring 4.0부터 지원하는, Condition 인터페이스를 상속받아 조건작성이 가능하다.
 * 해당 조건에 의해 Bean 노출을 제한할 수 있다.
 * 이 class는 JdbcTemplate class가 classPath에 존재하는 지 여부로 판단한다.
 *
 * Created by Jaeseong on 2020/07/24
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class JdbcTemplateCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        try {
            conditionContext.getClassLoader().loadClass("org.springframework.jdbc.core.JdbcTemplate");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
