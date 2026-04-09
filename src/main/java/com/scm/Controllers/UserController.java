package com.scm.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    //user dashboard page

    @RequestMapping(value="/dashboard")
    public String userDashboard() {
        System.out.println("User dashboard");
        return "user/dashboard";
    }

    @RequestMapping(value="/profile")
    public String userProfile() {
        return "user/profile";
    }
    
    
    //user add contactpage

    //user view contacts

    //user edit contacts

    //user delete contacts

    //user search contacts


}
