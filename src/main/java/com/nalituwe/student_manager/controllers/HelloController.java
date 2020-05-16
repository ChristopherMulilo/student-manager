package com.nalituwe.student_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/")
public class HelloController {

    @RequestMapping(method={RequestMethod.POST, RequestMethod.GET}, value="hello")
    public String printer(@RequestParam String name, Model model){
        String myGreeting="How are you"+ name +"!"+"nice to see you once again";
        model.addAttribute("greeting", myGreeting);
      return"hello";
    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return"goodbye";
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value="hello1")
    @ResponseBody
    public String helloWithPara(String name){
return "Hello"+" "+name;
    }

    @GetMapping("hello/{name}")
    @ResponseBody
    public String pathVariable(@PathVariable String name){
        return"Welcome "+name+" to the world of proper APIs";
    }

    @GetMapping("form")
    public String formInput(){

        return"form";
    }

    @GetMapping("hello-list")
        public String helloNames(Model model){
        List<String> namez = new ArrayList<>();
        namez.add("Chris");
        namez.add("Mwenda");
        namez.add("Mulilo");

        model.addAttribute("names", namez);
return"hello-list";
        }
}
