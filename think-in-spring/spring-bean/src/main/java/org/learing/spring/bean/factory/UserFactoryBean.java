package org.learing.spring.bean.factory;

import org.learing.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 *
 * {@link User} Bean de {@link FactoryBean} 实现
 *
 * @author Gaenan Wray
 * @data 2023/2/16 15:16
 * @since
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
