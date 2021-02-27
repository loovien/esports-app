package com.esportsmore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome(@RequestParam(name = "name", defaultValue = "luowen", required = false) String name) {
        ModelAndView welcome = new ModelAndView("welcome");
        welcome.addObject("name", name);
        return welcome;
    }
}
