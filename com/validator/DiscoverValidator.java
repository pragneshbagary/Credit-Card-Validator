package com.validator;

public class DiscoverValidator implements Validator{
    @Override
    public String validCard() {
        System.out.println("DiscoverCard");
        return "Discover Card";
    }
}
