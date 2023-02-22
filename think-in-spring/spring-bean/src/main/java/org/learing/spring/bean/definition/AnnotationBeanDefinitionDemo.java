package org.learing.spring.bean.definition;

import org.learing.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * 注解 BeanDefinition 示例
 *
 * @author Gaenan Wray
 * @data 2023/2/15 15:27
 * @since
 */

// 3、通过 @Import 来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class) // 通过 @Import 导入
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 配置类
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        // 通过 BeanDefinition 注册 API 实现
        // 1、命名 Bean 的注册方式
        registerUserBeanDefinitoin(applicationContext, "mercyblitz-user");
        // 2、非命名 Bean 的注册方式
        registerUserBeanDefinitoin(applicationContext);
        // 启动应用上下文
        applicationContext.refresh();
        // 按类型依赖查找
        Map<String, Config> configBeans = applicationContext.getBeansOfType(Config.class);
        System.out.println("Config 类型的所有beans：" + configBeans);
        System.out.println("User 类型的所有beans：" + applicationContext.getBeansOfType(User.class));


        // 显式的关闭 Spring 应用上下文
        applicationContext.close();
    }

    /**
     *
     *  命名 Bean 的注册方式
     *
     * @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinitoin(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1L)
                .addPropertyValue("name", "gaenan");

        // 判断如果 beanName 存在时
        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名 Bean 的注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);

        }



    }

    public static void registerUserBeanDefinitoin(BeanDefinitionRegistry registry) {
        registerUserBeanDefinitoin(registry, null);
    }

    // 2、通过 @Component 方式
    @Component //定义当前类作为 Spring Bean （组件）
    public static class Config {
        /**
         * 通过 Java 注解的方式，定义了一个Bean
         *
         * @return user
         */

        // 1、通过 @Bean 方式定义
        @Bean(name = {"user", "gaenan-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("GaenanWray");
            return user;
        }
    }

}
