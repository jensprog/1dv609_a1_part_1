package com.lab;

public class MyBuggySSNHelperAllow13Months implements ISSNHelper {
    
    @Override
    public boolean isCorrectLength(String stringInput) {
        return stringInput.length() == 11; // YYMMDD-XXXX
    }
    
    @Override
    public boolean isCorrectFormat(String stringInput) {
        // Regex pattern: 6 digits, hyphen, 4 digits
        return stringInput.matches("^\\d{6}-\\d{4}$");
    }
    
    @Override
    public boolean isValidMonth(String monthString) {
        int month = Integer.parseInt(monthString);
        return month >= 1 && month <= 13; // BUG: Allows 13 months
    }
    
    @Override
    public boolean isValidDay(String dayString) {
        int day = Integer.parseInt(dayString);
        return day >= 1 && day <= 31;
    }
    
    @Override
    public boolean luhnIsCorrect(String stringInput) {
        // Remove hyphen and convert to array of digits
        String digitsOnly = stringInput.replace("-", "");
        int sum = 0;
        
        for (int i = 0; i < digitsOnly.length(); i++) {
            int digit = Character.getNumericValue(digitsOnly.charAt(i));
            
            // Every second digit (starting from index 0) is doubled
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
