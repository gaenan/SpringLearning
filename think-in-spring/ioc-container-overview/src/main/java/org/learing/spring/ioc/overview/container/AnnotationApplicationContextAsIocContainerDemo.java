package org.learing.spring.ioc.overview.container;

import org.learing.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 注解能力 {@link ApplicationContext} 作为 Ioc 容器示例
 *
 * @author gaenanwray
 * @since
 */
@Configuration
public class AnnotationApplicationContextAsIocContainerDemo {

    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 AnnotationApplicationContextAsIocContainerDemo 作为配置类（Configuration Class）
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);
        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找集合对象
        lookupCollectionType(applicationContext);
        // 关闭应用上下文
        applicationContext.close();

    }

    /**
     * 通过 Java 注解的方式，定义了一个Bean
     *
     * @return user
     */
    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("GaenanWray");
        return user;
    }

    private static void lookupCollectionType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
//            for (User user : users.values()) {
//                System.out.println("Collection type lookup: "+user);
//            }
            System.out.println("查找到的所有的 User 集合对象" + users);

        }

    }

}
