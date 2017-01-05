package br.com.caelum.ingresso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nando on 04/01/17.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage(){
        return "home";
    }
}
