package com.ms.business.index.controller;

import com.ms.business.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jason
 * @since v1.0
 */
@Controller
public class IndexController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
