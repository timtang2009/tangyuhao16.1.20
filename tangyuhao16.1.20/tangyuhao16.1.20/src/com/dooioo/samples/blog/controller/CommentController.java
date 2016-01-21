package com.dooioo.samples.blog.controller;

import com.dooioo.samples.blog.hepler.CommentHelper;
import com.dooioo.samples.blog.model.Article;
import com.dooioo.samples.blog.model.Comment;
import com.dooioo.samples.blog.model.User;
import com.dooioo.samples.blog.service.ArticleService;
import com.dooioo.samples.blog.service.CommentService;
import com.dooioo.samples.common.Constants;
import com.dooioo.web.common.WebUtils;
import com.dooioo.web.controller.BaseController;
import com.dooioo.web.helper.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-8-14
 * Time: 下午5:58
 */
@Controller
@RequestMapping(value = "/article")
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/{id}/comment", method = RequestMethod.GET)
    public String show() {
        return "";
    }

    @RequestMapping(value = "/{id}/comment/add", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult create(@PathVariable int id, @RequestBody Comment comment, BindingResult result, HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER_V2);
        comment.setUserId(user.getId());
        if(commentService.insert(comment)) {
            return OK;
        }
        return FAIL;
    }

    @RequestMapping(value = "/{id}/comment/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request,
                       @PathVariable int id,
                       Model model) {
        int pageNo = WebUtils.findParamInt(request, "pageNo", 1);
        model.addAttribute("paginate", commentService.queryForPaginate(pageNo, id));
        return "/comment/list";
    }
}
