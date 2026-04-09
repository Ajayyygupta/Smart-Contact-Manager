package com.scm.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.Service.UserService;
import com.scm.entities.User;
import com.scm.entities.Users;
import com.scm.form.UserForm;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.helper.message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class PageController {

    @Autowired
    private UserService userService;

    //home page
    @RequestMapping("/home")
    public String home(Model model){

        System.out.println("Home Browser Handler");
        model.addAttribute("Name", "Ajay Gupta");
        model.addAttribute("Linkedin","https://www.linkedin.com/in/ajay-gupta-0051452a6");
        model.addAttribute("github", "https://github.com/Ajayyygupta/warehouse-inventory-tracker-jit.git");
        return "home";
    } 

    //about page

    @RequestMapping("/about")
    public String aboutPage(Model model) {
        System.out.println("About page loading");
        return "about";
    }
    //Services pagrr

      @RequestMapping("/services")
    public String servicePage(Model model) {
        System.out.println("Services page loading");
        return "services";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm=new UserForm();
        model.addAttribute("userForm", userForm);
        // userForm.setName("AjayGuptaaaaa");
        // userForm.setEmail("AjayBHAi@!23");
        // userForm.setPhoneNumber("12121212");
        return "register";
    }

    @RequestMapping(value="/do-register", method=RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session) {
      
       System.out.println("Processing Register");
       System.out.println(userForm);


       //validate the form data
       if(rBindingResult.hasErrors())
       {
        return "register";
       }

       //UserService
       //userForm-->User

        // User user=User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())  
        // .build();

        // User savedUser= userService.saveUser(user);

        
        Users user = new Users();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic(
                "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75");

        Users savedUser = userService.saveUser(user);

        //messge ="Regisyration succesfull"

        //add the message

        Message message=Message.builder().content("Registration Succesfully").type(MessageType.green).build();

        session.setAttribute("message", message);
        
        //redirect to login page
        return "redirect:/register";
    }
    

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    
    
    


}
