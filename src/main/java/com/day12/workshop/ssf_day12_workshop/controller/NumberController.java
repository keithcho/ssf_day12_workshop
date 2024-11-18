package com.day12.workshop.ssf_day12_workshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("")
public class NumberController {
    @GetMapping("/submit")
    public String numberForm(@RequestParam("inputNumber") int inputNumber, Model model) {
        Random random = new Random();
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < inputNumber) {
            int generatedNumber = random.nextInt(0, 31);
            if (!numberList.contains(generatedNumber)) { numberList.add(generatedNumber); }
        }
        model.addAttribute("inputNumber", inputNumber);
        model.addAttribute("numberList", numberList);
        return "output";
    }
    
}
