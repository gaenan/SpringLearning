package org.learing.spring.ioc.overview.dependency.lookup;

import org.learing.spring.ioc.overview.annotation.Super;
import org.learing.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 1、通过名称查找
 * 2、通过类型查找
 *
 * @author gaenanwray
 * @since
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        //配置XML配置文件
        //启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        //按类型查找
        lookupByType(beanFactory);
        //按照类型查找结合对象
        lookupCollectionType(beanFactory);
        //通过注解查找
        lookupByAnnotationType(beanFactory);

        //按名称查找
//        lookupInRealTime(beanFactory);
//        lookupInLazy(beanFactory);

    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
//            for (User user : users.values()) {
//                System.out.println("Collection type lookup: "+user);
//            }
            System.out.println("查找标注 @Super 所有的 User 集合对象" + users);

        }

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

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("按类型查找: " + user);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("Lazy lookup: " + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {

        User user = (User) beanFactory.getBean("user");
        System.out.println("lookup in realtime: " + user);

    }

}
