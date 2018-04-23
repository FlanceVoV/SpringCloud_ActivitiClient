package me.git.weizechen.controller;

import me.git.weizechen.server.api.ModelEditAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Shadow on 2018/04/18.
 * 模型控制层
 */
@Controller
@RequestMapping(value = "/modeler")
public class ModelderController {

    @Autowired
    private ModelEditAPI modelEditAPI;

}