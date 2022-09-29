package com.example.SeriesFinderApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;

/**
 * Provides Business Logic
 */

@RequestMapping("/")
@RestController
public class ApplicationController {

    @Autowired
 private  ApplicationService appService;


        @GetMapping ("/")
        public RedirectView home(){
            return new RedirectView("/home");
        }

        @RequestMapping("/home")
        public String homePage(){

            return "Please Enter Appropriate Numbers in the URL";

        }

    /**
     *
     * @param sequence  User inputs the sequence
     * @return calls the condition check arithmetic series method in ApplicationService
     */
    @GetMapping("/arithmetic")
    public BigDecimal arithmeticSum(  @RequestParam("sequence")   BigDecimal[] sequence){

            return  appService.arithmetic(sequence);

    }

    /**
     *
     * @param sequence User inputs the sequence
     * @return calls the condition check geometric series method in ApplicationService
     */

    @GetMapping ("/geometric")
    public BigDecimal geometricSum( @RequestParam("sequence") BigDecimal[] sequence){

            return  appService.geometric(sequence);

    }
}
