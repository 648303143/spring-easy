package com.spring.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.spring.beans.PropertyValue;
import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.config.BeanReference;
import com.spring.beans.factory.support.AbstractBeanDefinitionReader;
import com.spring.beans.factory.support.BeanDefinitionRegistry;
import com.spring.context.annotation.ClassPathBeanDefinitionScanner;
import com.spring.core.io.Resource;
import com.spring.core.io.ResourceLoader;
import org.w3c.dom.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * 读xml文件
 * @author zhangqingyang
 * @date 2022-07-04-18:01
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }


    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()){
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from"+resource,e);
        }

    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }

    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }
    public void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        Element documentElement = document.getDocumentElement();
        NodeList childNodes = documentElement.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            if (!(childNodes.item(i) instanceof Element)){
                continue;
            }
            if ("context:component-scan".equals(childNodes.item(i).getNodeName())){
                Element componentScan = (Element) childNodes.item(i);
                if (componentScan != null) {
                    String scanPath = componentScan.getAttribute("base-package");
                    if (StrUtil.isEmpty(scanPath)){
                        throw new BeansException("The value of base-package attribute can not be empty or null");
                    }
                    scanPackage(scanPath);
                }
            }
            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }

            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            String initMethod = bean.getAttribute("init-method");
            String destroyMethodName = bean.getAttribute("destroy-method");
            String beanScope = bean.getAttribute("scope");


            Class<?> clazz = Class.forName(className);
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            if (StrUtil.isNotEmpty(beanScope)) {
                beanDefinition.setScope(beanScope);
            }

            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)){
                    continue;
                }
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {
                    continue;
                }
                Element property = (Element) bean.getChildNodes().item(j);
                String propName = property.getAttribute("name");
                String propValue = property.getAttribute("value");
                String propRef = property.getAttribute("ref");

                Object value = StrUtil.isNotEmpty(propRef) ? new BeanReference(propRef) : propValue;
                PropertyValue propertyValue = new PropertyValue(propName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            getRegistry().registerBeanDefinition(beanName,beanDefinition);

        }

    }

    private void scanPackage(String scanPath) {
        String[] basePackages = StrUtil.splitToArray(scanPath, ',');
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(getRegistry());
        scanner.doScan(basePackages);
    }
}
