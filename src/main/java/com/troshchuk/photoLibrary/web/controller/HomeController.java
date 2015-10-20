package com.troshchuk.photoLibrary.web.controller;

import com.troshchuk.photoLibrary.domain.User;
import com.troshchuk.photoLibrary.security.CaptchaContainer;
import com.troshchuk.photoLibrary.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  19.08.14.
 */
@Controller
public class HomeController {
    private static final Logger LOGGER = LogManager.getLogger(HomeController.class.getName());

    @Autowired
    private CaptchaContainer captchaContainer;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage() {
        LOGGER.info("Open home page");
        return "home";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletRequest request) {
        HashMap<String, String> model = new HashMap<String, String>();
        model.put("answer", captchaContainer.getCaptcha(request.getRequestedSessionId()));
        model.put("random", String.valueOf((int) Math.floor(Math.random() * 100) + 100));
        return new ModelAndView("login", model);
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public String register(@RequestParam String email, @RequestParam String password) {
        User user = new User(email.toLowerCase());
        userService.create(user, password);
        return "login";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String registrationPage() {
        return "registration";
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String adminPage() {
        LOGGER.info("Open admin page");
        return "admin";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesssDenied() {
        LOGGER.info("Try open page which user don't have permission!");
        return "403";

    }

}
