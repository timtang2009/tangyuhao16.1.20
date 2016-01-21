package com.dooioo.samples.blog.controller;

import com.dooioo.commons.Strings;
import com.dooioo.samples.blog.model.User;
import com.dooioo.samples.common.Constants;
import com.dooioo.web.controller.BaseController;
import com.dooioo.web.helper.JsonResult;
import com.dooioo.web.model.BaseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-8-25
 * Time: 下午7:44
 */
public abstract class BaseSampleControler extends BaseController {

    public User getSession(HttpServletRequest request) {
        return  (User) request.getSession().getAttribute(Constants.SESSION_USER_V2);
    }

}
