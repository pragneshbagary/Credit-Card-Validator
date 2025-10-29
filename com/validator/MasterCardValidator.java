package com.validator;

public class MasterCardValidator implements Validator{
    @Override
    public String validCard() {
        System.out.println("MasterCard");
        return "Master Card";
    }
}
