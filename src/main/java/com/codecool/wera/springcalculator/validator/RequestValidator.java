package com.codecool.wera.springcalculator.validator;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RequestValidator {

    public boolean isValid(HttpServletRequest request) throws NumberFormatException {

        String first = request.getParameter("first");
        String operator = request.getParameter("operator");
        String second = request.getParameter("second");

        if (isDivision(operator) && isDivisionImpossible(second)) throw new IllegalArgumentException("do not divide by zero");

        return isNumber(first) && isNumber(second);
    }

    private boolean isNumber(String number) throws NumberFormatException {

            Double d = Double.parseDouble(number);
            return true;
    }

    private boolean isDivision(String operator) {
        return operator.equals("/");
    }

    private boolean isDivisionImpossible(String divident) {
        return divident.equals("0");
    }
}
