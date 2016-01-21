package com.dooioo.samples.blog.hepler;

import com.dooioo.commons.Strings;
import com.dooioo.samples.blog.model.User;
import com.dooioo.web.common.Validations;
import org.springframework.validation.Errors;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-8-15
 * Time: 下午3:20
 */
public class UserHelper {

    public static void vaildRegister(User user, Errors errors) {
        Validations.rejectIfEmpty(errors, "name", "用户名必填");
        Validations.rejectIfEmpty(errors, "email", "电子邮件必填");
        Validations.rejectIfEmpty(errors, "password", "密码必填");
    }
}
