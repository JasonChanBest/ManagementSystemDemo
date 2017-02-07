package com.ms.controller;

import com.ms.form.user.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jason
 * @since v1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/loginInit")
    public String loginInit(@ModelAttribute LoginForm loginForm) {
        return "user/login";
    }
}
