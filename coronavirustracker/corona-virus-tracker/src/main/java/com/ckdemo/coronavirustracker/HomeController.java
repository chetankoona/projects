package com.ckdemo.coronavirustracker;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.StringReader;

@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private CoronaInfectionService coronaInfectionService;

    @RequestMapping(value = "/")
    public String home(Model model){
        model.addAttribute("infectionStatsList",coronaInfectionService.getInfectionStats());
        return "home";
    }
}
