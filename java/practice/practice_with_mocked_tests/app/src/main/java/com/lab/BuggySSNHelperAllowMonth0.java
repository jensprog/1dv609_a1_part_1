package com.lab;

public class BuggySSNHelperAllowMonth0 implements ISSNHelper {
    
    @Override
    public boolean isCorrectLength(String stringInput) {
        return stringInput.length() >= 11; 
    }
    
    @Override
    public boolean isCorrectFormat(String stringInput) {
        return stringInput.matches("^\\d{6}-\\d{4}$");
    }
    
    @Override
    public boolean isValidMonth(String monthString) {
        int month = Integer.parseInt(monthString);
        return month >= 0 && month <= 12;
    }
    
    @Override
    public boolean isValidDay(String dayString) {
        int day = Integer.parseInt(dayString);
        return day >= 1 && day <= 31;
    }
    
    @Override
    public boolean luhnIsCorrect(String stringInput) {
        String digitsOnly = stringInput.replace("-", "");
        int sum = 0;
        
        for (int i = 0; i < digitsOnly.length(); i++) {
            int digit = Character.getNumericValue(digitsOnly.charAt(i));
            
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
        }
        
        return sum % 10 == 0;
    }
}
