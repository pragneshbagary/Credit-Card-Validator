package com.validator;

public class ValidatorFactory {
    public Validator checkCard(String str){
        if(str.isEmpty() || !str.matches("^[0-9]*$") )
            return new InvalidCard();

        if(str.charAt(0) == '3' && (str.charAt(1) == '4' || str.charAt(1) == '7') && str.length() == 15){
            return new AmericanExpressValidator();
        } else if (str.charAt(0) == '4' && (str.length() == 13 || str.length() == 16)) {
            return new VisaValidator();
        } else if (str.charAt(0) == '5' && (str.charAt(1) >= '1' && str.charAt(1) <= '5') && str.length() == 16) {
            return new MasterCardValidator();
        }
        else if (str.substring(0,4).equals("6011") && str.length() == 16){
            return new DiscoverValidator();
        }
        else
//            System.out.println("invalid");
            return new InvalidCard();
    }
}
