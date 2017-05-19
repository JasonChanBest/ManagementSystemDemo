package com.ms.business.menu.controller;

import com.ms.business.menu.entity.Menu;
import com.ms.business.menu.form.AddForm;
import com.ms.business.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping("/rootMenus")
    public List<Menu> rootMenus() {
        List<Menu> menus = menuService.rootMenus();
        return menus;
    }

    @RequestMapping("/addInit")
    public String addInit(@ModelAttribute("form")AddForm form) {
        return "addInit";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute @Valid  AddForm form , BindingResult result) {
        if(result.hasErrors())
            return "addInit";

        Menu parent = menuService.get(form.getParentId());

        Menu menu = new Menu();
        menu.setName(form.getName());
        menu.setParent(parent);
        menuService.save(menu);
        return "list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        menuService.delete(id);
        return "list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Menu> menus = menuService.list();
        model.addAttribute("menus", menus);
        return "menu/list";
    }

    @RequestMapping("/modifyInit")
    public String modifyInit() {

        return "modify";
    }

}
