package com.dooioo.samples.blog.controller;

import com.dooioo.samples.blog.hepler.ArticleHelper;
import com.dooioo.samples.blog.model.Article;
import com.dooioo.samples.blog.model.Category;
import com.dooioo.samples.blog.model.Comment;
import com.dooioo.samples.blog.model.User;
import com.dooioo.samples.blog.service.ArticleService;
import com.dooioo.samples.blog.service.CategoryService;
import com.dooioo.samples.blog.service.CommentService;
import com.dooioo.samples.common.Constants;
import com.dooioo.web.common.Paginate;
import com.dooioo.web.common.WebUtils;
import com.dooioo.web.exception.IllegalOperationException;
import com.dooioo.web.exception.NotFoundException;
import com.dooioo.web.helper.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-11-2
 * Time: 下午4:02
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController extends BaseSampleControler {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.queryForList();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list( @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                        HttpServletRequest request,
                        Model model) {
        Integer categoryId = WebUtils.findParamInt(request, "cateId");
        Paginate paginate = articleService.queryForPaginate(pageNo, categoryId);
        model.addAttribute("paginate", paginate);
        return "/article/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable int id, HttpServletRequest request, Model model) throws NotFoundException {
        Article article = articleService.findById(id);
        if(article == null) {
            throw new NotFoundException("该文章不存在.");
        } else {
            model.addAttribute(article);
            model.addAttribute("comments", commentService.queryForList(article.getId()));
            model.addAttribute("comment", new Comment());
            OK.put("tt", "test");
            ok().put("ccc", "test");
            return "/article/show";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        Article article = new Article();
        model.addAttribute(article);
        return "/article/form";
    }

    //参数次序不能调整，否则会报找不到方法
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(@ModelAttribute Article article, BindingResult result, HttpServletRequest request, Model model) {
        ArticleHelper.validate(result);
        if(result.hasErrors()) {
            return "/article/form";
        } else {
            User user = (User) request.getSession().getAttribute(Constants.SESSION_USER_V2);
            article.setUserId(user.getId());
            if(articleService.insert(article)) {
                return "redirect:/article";
            } else {
                return "/article/form";
            }
        }
    }

    /**
     * 以Json格式的提交
     * 如果格式符合javabean命名规则，则可以直接转换成bean对象
     *
     * 如果是get提交，注解为：produces="application/json"
     * @param article
     * @param result
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/add/json", consumes="application/json",  method = RequestMethod.POST)
    public String createByJson(@RequestBody Article article, BindingResult result, HttpServletRequest request, Model model) {
        ArticleHelper.validate(result);
        if(result.hasErrors()) {
            return "/article/form";
        } else {
            User user = (User) request.getSession().getAttribute(Constants.SESSION_USER_V2);
            article.setUserId(user.getId());
            if(articleService.insert(article)) {
                return "redirect:/article";
            } else {
                return "/article/form";
            }
        }
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable int id, HttpServletRequest request, Model model) throws NotFoundException {
        Article article = articleService.findById(id);
        if(article == null) {
            throw new NotFoundException("该文章不存在.");
        }

        User user = getSession(request);
        if(user.getId() != article.getUserId()) {
            throw new NotFoundException("没有权限.");
        }

        model.addAttribute(article);
        return "/article/form";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String update(@ModelAttribute Article article, BindingResult result, HttpServletRequest request, Model model) {
        ArticleHelper.validate(result);
        Article oldArticle = articleService.findById(article.getId());
        if(oldArticle == null) {
            return "error";
        }

        if(result.hasErrors()) {
            return "/article/form";
        }
        articleService.update(article);
        return "redirect:/article/{id}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody JsonResult delete(@PathVariable int id, HttpServletRequest request, Model model) throws Exception {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER_V2);
        if(user == null) {
            throw new IllegalArgumentException("请先登录.");
        }
        Article article = articleService.findById(id);
        if(article == null) {
            throw new NotFoundException("该文章不存在.");
        } else if (article.getUserId() != user.getId()) {
            throw new IllegalArgumentException("只能删除自己的.");
        } else {
            if(articleService.delete(id)) {
                return OK;
            } else {
                return FAIL;
            }
        }
    }

    @RequestMapping(value = "/{id}/getJson", method = RequestMethod.GET)
    public @ResponseBody JsonResult getJson(@PathVariable int id) throws NotFoundException {
        Article article = articleService.findById("findById", id);
        if(article == null) {
            throw new NotFoundException("该文章不存在.");
        } else {
            return OK;
        }
    }
}
