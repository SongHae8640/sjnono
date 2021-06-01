package com.sjnono.demo.domain.ex.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex")
public class ExController {

    @GetMapping
    public String goExPage(){

        return "domain/ex/example";
    }


}
