package com.saniazt.springApp1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false) String name,
                            @RequestParam(value = "surname",required = false)String surname,
                            Model model){

       // System.out.println("Hello," +name+" "+surname);
        model.addAttribute("message","Hello," +name+" "+surname);

        return "first/hello";
    }
    @GetMapping("/calculate")
    public String calculatorPage( @RequestParam(value = "a",required = false) int a,
                              @RequestParam(value = "b",required = false) int b,
                              @RequestParam(value = "action",required = false) String action,
                              Model model2){
        double result;
        switch (action) {
            case ("multiplication"): {result=a*b;} break;
            case ("addition"): {result=a+b;} break;
            case ("subtraction"): {result=a-b;} break;
            case ("division"): {result=a/(double)b;} break;
            default: result=0;
        }
        model2.addAttribute("calculationOperation","Result is "+result);

        return "first/calculate";
    }

    @GetMapping("/goodbye")
    public String gooByePage(){
        return "first/goodbye";
    }
}
