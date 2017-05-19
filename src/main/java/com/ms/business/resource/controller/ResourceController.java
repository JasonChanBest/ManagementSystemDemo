package com.ms.business.resource.controller;

import com.ms.business.resource.entity.Resource;
import com.ms.business.resource.form.AddForm;
import com.ms.business.resource.form.ModifyForm;
import com.ms.business.resource.service.ResourceService;
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
        return "resource/add";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute("form") AddForm form) {
        Resource resource = new Resource();
        resource.setName(form.getName());
        resource.setUrl(form.getUrl());
        resourceService.save(resource);
        return "forward:/resource/list.do";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        resourceService.delete(id);
        return "forward:/resource/list.do";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Resource> resources = resourceService.list();
        model.addAttribute("resources", resources);
        return "resource/list";
    }

    @RequestMapping("/modifyInit")
    public String modifyInit(Long id , Model model) {
        Resource resource = resourceService.get(id);
        model.addAttribute("resource" , resource);
        return "resource/modify";
    }

    @RequestMapping("/modify")
    public String modify(@ModelAttribute("form") ModifyForm modifyForm) {
        Resource resource = resourceService.get(modifyForm.getId());
        resource.setName(modifyForm.getName());
        resource.setUrl(modifyForm.getUrl());
        resourceService.save(resource);
        return "resource/modify";
    }

}
