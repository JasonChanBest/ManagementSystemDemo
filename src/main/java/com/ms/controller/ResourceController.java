package com.ms.controller;

import com.ms.entity.Resource;
import com.ms.form.resource.AddForm;
import com.ms.form.resource.ModifyForm;
import com.ms.service.ResourceService;
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
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/addInit")
    public String addInit(@ModelAttribute("form") AddForm form) {
        return "add";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute("form") AddForm form) {
        Resource resource = new Resource();
        resource.setName(form.getName());
        resource.setUrl(form.getUrl());
        resourceService.save(resource);
        return "list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        resourceService.delete(id);
        return "list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Resource> resources = resourceService.list();
        model.addAttribute("resources", resources);
        return "list";
    }

    @RequestMapping("/modify")
    public String modify(@ModelAttribute("form") ModifyForm modifyForm) {
        Resource resource = resourceService.get(modifyForm.getId());
        resource.setName(modifyForm.getName());
        resource.setUrl(modifyForm.getUrl());
        resourceService.save(resource);
        return "modify";
    }

}
