package com.dooioo.samples.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-10-23
 * Time: 上午11:13
 */
@Component
public class JobTest  {

    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @PostConstruct
    public void run() {
        System.out.println(userService);
        System.out.println(categoryService);
        System.out.println("=============JobTest Runing...========================");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("==============JobTest end ...===========================");
    }

    public void run2() {
        System.out.println("=============JobTest2 Runing...========================");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("==============JobTest2 end ...===========================");
    }

}
