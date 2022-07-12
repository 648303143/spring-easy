package com.spring.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author zhangqingyang
 * @date 2022-07-12-14:49
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
