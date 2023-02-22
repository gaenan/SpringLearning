package org.learing.spring.ioc.overview.dependency.Injection;

import org.learing.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入示例
 * 1、通过名称注入
 * 2、通过类型注入
 *
 * @author gaenanwray
 * @since
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        //配置XML配置文件
        //启动应用上下文
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INFO/dependency-injection-context.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        // 依赖来源1：自定义 Bean
        UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository.getUsers());

        // 依赖来演2：依赖注入（内建依赖）
        System.out.println(userRepository.getBeanFactory());

        ObjectFactory userFactory = userRepository.getObjectFactory();
        System.out.println(userFactory.getObject());

        //依赖查找
//        System.out.println(applicationContext.getBean(BeanFactory.class));

        // 依赖来源3：容器内建 Bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取 Enviroment 类型的 bean: " + environment);

    }

    private static void whoIsIocContainer(UserRepository userRepository, ApplicationContext applicationContext) {

        // 这个表达式为什么不会成立
        System.out.println(userRepository.getBeanFactory() == applicationContext);

        // ApplicationContext is BeanFactory

    }

}
