package com.sansoft.loginController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sandroid on 3/29/2018.
 */
@Controller
public class LoginController {

    @RequestMapping("/index")
    public String getPage(){
        return "index";
    }

    @RequestMapping("/sign-in")
    public String getLoginPage(){
        return "sign-in";
    }

    @RequestMapping(value = "/sign-up",method = RequestMethod.GET)
    public String getSignUpPage(){
        return "sign-up";
    }

    @RequestMapping("/user")
    public String getUser(){
        return "user";
    }


}
