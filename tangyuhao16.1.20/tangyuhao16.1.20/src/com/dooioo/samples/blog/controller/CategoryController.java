package com.dooioo.samples.blog.controller;

import com.dooioo.samples.blog.model.Category;
import com.dooioo.samples.blog.model.User;
import com.dooioo.samples.blog.service.CategoryService;
import com.dooioo.samples.common.Constants;
import com.dooioo.web.controller.BaseController;
import com.dooioo.web.helper.JsonResult;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-8-14
 * Time: 涓嬪崍5:57
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(String categoryName, HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER_V2);
        if(user!=null){
	        if (StringUtils.isBlank(categoryName)) {
	            throw new IllegalArgumentException("请输入正确的分类名称！");
	        }
	        Category category  = new Category();
	        category.setCreatedAt(new Date());
	        category.setName(categoryName);
	        categoryService.insert(category);
	        return "redirect:/article";
        } else {
            throw new IllegalArgumentException("无操作权限！");
        }
    }

    @RequestMapping(value = "/add", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody JsonResult create(@RequestBody Category category, HttpServletRequest request, Model model) {
        if (category == null) {
            throw new IllegalArgumentException("请传入正确的分类！");
        }
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER_V2);
        if(user!=null){
            category.setCreatedAt(new Date());
            if(categoryService.insert(category)) {
                return OK;
            } else {
            	return FAIL;
            }
        } else {
        	throw new IllegalArgumentException("无操作权限！");
        }
    }
    
    @RequestMapping(value="/{id}/delete",method=RequestMethod.DELETE)
    public @ResponseBody JsonResult deleteCategory(@PathVariable int id,HttpServletRequest request){
    	User user = (User) request.getSession().getAttribute(Constants.SESSION_USER_V2);
    	if(user!=null){
    		if("admin".equals(user.getName())){
    			return OK;
    		}
    	}
    	return FAIL;
    }
    
}
