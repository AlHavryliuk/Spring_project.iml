package org.example.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/error")
public class ErrorController {

    @RequestMapping(value = "/errorPage", method = RequestMethod.GET)
    public ModelAndView errorPage () {

        return new ModelAndView("errorPage");
    }
}
