package org.learing.spring.ioc.dependency.injection;

import org.learing.spring.ioc.overview.domain.User;

/**
 * <a>SpringLearning</a>
 *
 * <p>Title: UserHolder</p>
 * <p>Description: {@link User} 的 Holder 类</p>
 *
 * @author <a>Gaenan Wray 魏靖南 字午牛 号北窗伏龙</a>
 * @date 2023-2月-21 周二 14:25
 * @since
 */
public class UserHolder {
    private User user;

    public UserHolder(User user) {
        this.user = user;
    }

    public UserHolder() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
