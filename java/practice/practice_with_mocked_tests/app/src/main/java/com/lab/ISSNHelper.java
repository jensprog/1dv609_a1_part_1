package com.lab; 

public interface ISSNHelper {
  boolean isCorrectLength(String stringInput);
  boolean isCorrectFormat(String stringInput);
  boolean isValidMonth(String monthString);
  boolean isValidDay(String dayString);
  boolean luhnIsCorrect(String stringInput);
}
