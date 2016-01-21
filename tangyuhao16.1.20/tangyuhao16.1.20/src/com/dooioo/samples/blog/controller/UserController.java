package com.dooioo.samples.blog.controller;

import com.dooioo.samples.blog.hepler.UserHelper;
import com.dooioo.samples.blog.model.User;
import com.dooioo.samples.blog.service.UserService;
import com.dooioo.samples.common.Constants;
import com.dooioo.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-8-14
 * Time: 下午4:39
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute(new User());
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(@ModelAttribute User user,
                                       HttpServletRequest request,
                                       HttpServletResponse response,
                                       HttpSession session) {
        User sessionUser = userService.queryFirst(user);
        if(sessionUser == null) {
            return "/login";
        }

        session.setAttribute(Constants.SESSION_USER_V2, sessionUser);
        return "redirect:/article";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "/user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submitRegister(@ModelAttribute User user, BindingResult result, HttpSession session) {
        UserHelper.vaildRegister(user, result);
        if(result.hasErrors()) {
            return "/user/register";
        } else {
            userService.insert(user);
            return "redirect:/article";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, Model model) {
        request.getSession().setAttribute(Constants.SESSION_USER_V2, null);
        return "redirect:/article";
    }
}
