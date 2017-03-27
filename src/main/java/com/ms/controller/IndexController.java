package com.ms.controller;

import com.ms.entity.Menu;
import com.ms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping("/baseFrame")
    public String baseFrame(HttpSession session) {
        if(session.getAttribute("menus") == null) {
            List<Menu> menus = menuService.findByParent(null);
            session.setAttribute("menus" , menus);
        }
        return "base-frame";
    }
}
