package com.codecool.wera.springcalculator.controller;

import com.codecool.wera.springcalculator.service.CalculatorService;
import com.codecool.wera.springcalculator.validator.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CalculatorController {

    @Autowired
    RequestValidator validator;

    @Autowired
    CalculatorService service;

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String calcForm() {
        return "formulator";
    }
    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String calc(HttpServletRequest request, Model model) {

        if (validator.isValid(request)) {
            String first = request.getParameter("first");
            String operator = request.getParameter("operator");
            String second = request.getParameter("second");

            Integer outcome = service.doOperation(first, operator, second);
            model.addAttribute("operand1", first);
            model.addAttribute("operator", operator);
            model.addAttribute("operand2", second);
            model.addAttribute("outcome", outcome);
        }

        return "formulator";
    }
}
