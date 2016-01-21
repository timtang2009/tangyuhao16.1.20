package com.dooioo.samples.blog.service;

import com.dooioo.samples.blog.model.User;
import com.dooioo.web.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-8-14
 * Time: 下午4:24
 */
@Service
public class UserService extends BaseService<User> {

    public User checkUser(User user) {
        return super.queryFirst(sqlId("checkUser"), user);
    }

    public User checkUser2(User user) {
        return super.queryFirst("checkUser", user);
    }


}
