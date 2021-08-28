package com.sjnono.demo.domain.stckPrc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stckPrc")
public class StckPrcController {

    @Autowired
    StckPrcService stckPrcService;


    @GetMapping("/{standardCode}")
    public String getStckPrc(@PathVariable String standardCode , Model model){
        return "domain/stckPrc/stckPrc";
    }


}

