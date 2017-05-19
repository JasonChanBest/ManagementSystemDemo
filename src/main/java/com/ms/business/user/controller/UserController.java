package com.ms.business.user.controller;

import com.ms.business.user.entity.User;
import com.ms.business.user.form.AddForm;
import com.ms.business.user.form.LoginForm;
import com.ms.business.user.form.ModifyForm;
import com.ms.business.role.service.RoleService;
import com.ms.business.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/loginInit")
    public String loginInit(@ModelAttribute LoginForm loginForm) {
        return "user/login";
    }

    @RequestMapping("/addInit")
    public String addInit(@ModelAttribute("form")AddForm form) {
        return "user/add";
    }

    @RequestMapping("/add")
    public String add(AddForm form) {
        User user = new User();
        user.setName(form.getName());
        user.setPassword(form.getPassword());
        user.setEnable(form.getEnable());
        user.setImgPath(form.getImgPath());
        user.setRoles(roleService.findAll(form.getRoleIds()));
        userService.save(user);
        return "forward:/user/list.do";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "forward:/user/list.do";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users = userService.list();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/modifyInit")
    public String modifyInit(Long id , @ModelAttribute("form") ModifyForm form , Model model) {
        User user = userService.get(id);
        model.addAttribute("user" , user);
        return "user/modify";
    }

    @RequestMapping("/modify")
    public String modify(ModifyForm form , Model model) {
        User user = userService.get(form.getId());
        user.setName(form.getName());
        user.setPassword(form.getPassword());
        user.setEnable(form.getEnable());
        user.setImgPath(form.getImgPath());
        user.setRoles(roleService.findAll(form.getRoleIds()));
        userService.save(user);
        return "user/modify";
    }
}
