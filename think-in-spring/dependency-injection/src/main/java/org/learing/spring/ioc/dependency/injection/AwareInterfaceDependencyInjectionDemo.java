package org.learing.spring.ioc.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <a>SpringLearning</a>
 *
 * <p>Title: XmlDependencySetterInjectionDemo</p>
 * <p>Description: 基于 {@link Aware} 接口回调的依赖注入示例</p>
 *
 * @author <a>Gaenan Wray 魏靖南 字午牛 号北窗伏龙</a>
 * @date 21 周二 13:35
 * @since
 */
public class AwareInterfaceDependencyInjectionDemo implements BeanFactoryAware, ApplicationContextAware {

    private static BeanFactory beanFactory;

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 配置类 -> Spring Bean
        context.register(AwareInterfaceDependencyInjectionDemo.class);

        // 启动应用上下文
        context.refresh();
        System.out.println(beanFactory == context.getBeanFactory());
        System.out.println(applicationContext == context);

        // 显式的关闭 Spring 应用上下文
        context.close();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.applicationContext = applicationContext;
    }
}
