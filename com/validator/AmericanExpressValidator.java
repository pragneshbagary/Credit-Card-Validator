package com.validator;

public class AmericanExpressValidator implements Validator{

    @Override
    public String validCard() {
        System.out.println("American Express");
        return "American Express";
    }
}
