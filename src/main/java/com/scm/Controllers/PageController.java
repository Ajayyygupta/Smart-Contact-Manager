package com.scm.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){

        System.out.println("Home Browser Handler");
        model.addAttribute("Name", "Ajay Gupta");
        model.addAttribute("Linkedin","https://www.linkedin.com/in/ajay-gupta-0051452a6");
        model.addAttribute("github", "https://github.com/Ajayyygupta/warehouse-inventory-tracker-jit.git");
        return "home";
    } 



    @RequestMapping("/about")
    public String aboutPage(Model model) {

        model.addAttribute("isLogin", true);

        System.out.println("About page loading");
        return "about";

    }


      @RequestMapping("/services")
    public String servicePage(Model model) {
        model.addAttribute("isLogin",false
            
        );

        System.out.println("Services page loading");
        return "services";
    }


}
