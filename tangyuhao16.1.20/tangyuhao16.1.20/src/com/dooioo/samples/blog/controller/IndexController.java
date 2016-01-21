package com.dooioo.samples.blog.controller;

import com.dooioo.web.controller.BaseController;
import com.dooioo.web.helper.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-8-17
 * Time: 下午5:39
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String show() {
        return "redirect:/article";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String view404Error( @RequestParam(value = "message", defaultValue = "", required = false) String message, Model model) {
        model.addAttribute("message", message);
        return "common/notfound";
    }

    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public String view500Error( @RequestParam(value = "message", defaultValue = "", required = false) String message, Model model) {
        model.addAttribute("message", message);
        return "common/500";
    }

    @RequestMapping(value = "/testJson", method = RequestMethod.GET)
    public @ResponseBody JsonResult testJson() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return OK;
    }
}
