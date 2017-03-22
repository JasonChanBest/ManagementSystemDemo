package com.ms.controller;

import com.ms.entity.Role;
import com.ms.form.role.AddForm;
import com.ms.form.role.ModifyForm;
import com.ms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/addInit")
    public String addInit(@ModelAttribute("form") AddForm form) {
        return "role/save";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute("form") AddForm form) {
        Role role = new Role();
        role.setName(form.getName());
        roleService.save(role);
        return "forward:/role/list.do";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long roleId) {
        roleService.delete(roleId);
        return "role/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Role> roles = roleService.list();
        model.addAttribute("roles" , roles);
        return "role/list";
    }

    @RequestMapping("/modifyInit")
    public String modifyInit(Model model , @RequestParam Long roleId , @ModelAttribute ModifyForm form) {
        Role role = roleService.get(roleId);
        model.addAttribute("role" , role);
        return "role/modify";
    }

    @RequestMapping("/modify")
    public String modify(ModifyForm form) {
        Role role = roleService.get(form.getId());
        role.setName(form.getName());
        roleService.save(role);
        return "forward:/role/list.do";
    }
}
