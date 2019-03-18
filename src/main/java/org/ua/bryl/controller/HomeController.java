package org.ua.bryl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by olegbryl 18/03/2019.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if(error != null) {
            model.addAttribute("error", "The username or password are invalid");
        }
        if(logout != null) {
            model.addAttribute("msg", "The session has ended successfully");
        }

        return "login";
    }
}
