package org.learing.spring.bean.factory;

import org.learing.spring.ioc.overview.domain.User;

/**
 * {@link User} 工厂类
 *
 * @author Gaenan Wray
 * @data 2023/2/16 14:59
 * @since
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }

}
