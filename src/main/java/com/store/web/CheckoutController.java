package com.store.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CheckoutController {

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout(Model model) {

        return "checkout";
    }

}
