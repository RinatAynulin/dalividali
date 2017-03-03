package com.aynulin.dalividali.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Aynulin on 31.01.2017.
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    protected static final String VIEW_NAME_LOGIN_PAGE = "user/login";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/app";
        }
        LOGGER.debug("Rendering login page.");
        return VIEW_NAME_LOGIN_PAGE;
    }
}