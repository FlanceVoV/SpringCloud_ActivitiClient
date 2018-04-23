package me.git.weizechen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shadow on 2018/04/18.
 * 欢迎页面
 */
@Controller
public class WelcomeController {
    @RequestMapping(value = {"","/"})
    public String index() {
        return "index";
    }
}