package org.learing.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * <a>SpringLearning</a>
 *
 * <p>Title: XmlDependencyConstructorInjectionDemo</p>
 * <p>Description: 基于 XML 资源的依赖 Constructor 注入示例</p>
 *
 * @author <a>Gaenan Wray 魏靖南 字午牛 号北窗伏龙</a>
 * @date 21 周二 13:35
 * @since
 */
public class XmlDependencyConstructorInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResourcePath = "classpath:/META-INF/dependency-constructor-injection.xml";
        // 加载 XML 资源，解析且生成 BeanDefinition
        reader.loadBeanDefinitions(xmlResourcePath);
        // 依赖查找并且创建 Bean
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);

        System.out.println(userHolder);
    }

}
