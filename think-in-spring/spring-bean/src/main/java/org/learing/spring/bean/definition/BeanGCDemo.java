package org.learing.spring.bean.definition;

import org.learing.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * Bean 垃圾回收（GC）示例
 *
 * @author Gaenan Wray
 * @date 2023/2/17 11:17
 * @since
 */
public class BeanGCDemo {

    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 配置类
        applicationContext.register(BeanInitialzationDemo.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 关闭 Spring 应用上下文
        applicationContext.close();
//        Thread.sleep(5000lL); // 在JAVA 17 19 里不用线程等待，因为重写的垃圾回收方法会执行
        // 强制触发 GC
        System.gc();

    }

}
