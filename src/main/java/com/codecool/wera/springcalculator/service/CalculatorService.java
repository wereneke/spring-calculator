package com.codecool.wera.springcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Integer doOperation(String operand1, String operator, String operand2) {
        Integer result = null;
        Integer o1 = Integer.valueOf(operand1);
        Integer o2 = Integer.valueOf(operand2);

        switch (operator) {
            case "+" : result = o1 + o2;
            break;
            case "-" : result = o1 - o2;
            break;
            case "*" : result = o1 * o2;
            break;
            case "/" : result = o1 / o2;
        }
        return result;
    }
}
