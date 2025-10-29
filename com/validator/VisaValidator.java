package com.validator;

public class VisaValidator implements Validator{
    @Override
    public String validCard() {
        System.out.println("Visa Card");
        return "visa Card";
    }
}
