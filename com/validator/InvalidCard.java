package com.validator;

public class InvalidCard implements Validator{
    @Override
    public String validCard() {
        System.out.println("invalid");
        return "Invalid Card Type";
    }
}
