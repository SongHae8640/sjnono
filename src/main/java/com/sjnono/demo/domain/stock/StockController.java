package com.sjnono.demo.domain.stock;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @Autowired
    ModelMapper modelMapper;





}
