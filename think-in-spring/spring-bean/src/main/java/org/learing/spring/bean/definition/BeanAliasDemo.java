package org.learing.spring.bean.definition;

import org.learing.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 *
 * @author gaenanwray
 * @since
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        //配置XML配置文件
        //启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        //通过过别名的方式获取 user 的 bean
        User user = beanFactory.getBean("user", User.class);
        User gaenanUser = beanFactory.getBean("gaenan-user", User.class);
        System.out.println("gaenan-user 是否与 user bean 相同: " + (user == gaenanUser));
    }

}
