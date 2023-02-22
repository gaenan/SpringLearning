package org.learing.spring.bean.definition;

import org.learing.spring.bean.factory.DefaultUserFactory;
import org.learing.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Bean 初始化 Demo
 *
 * @author Gaenan Wray
 * @date 2023/2/17 09:40
 * @since
 */
@Configuration // Configuration class
public class BeanInitialzationDemo {

    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 配置类
        applicationContext.register(BeanInitialzationDemo.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
        System.out.println("Spring 应用上下文已启动 。。。");
        // 依赖查找
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);

        // 关闭 Spring 应用上下文
        System.out.println("Spring 应用上下文准备关闭 。。。");
        applicationContext.close();
        System.out.println("Spring 应用上下文已关闭 。。。");
    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
    @Lazy(false)
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }

}
