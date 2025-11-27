package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class SSNHelperTest {

  private ISSNHelper helper;

  private ISSNHelper createHelper() {
    return new SSNHelper();
    //return new BuggySSNHelperAllowDayUpTo30();
    //return new BuggySSNHelperAllowMonth0();
    //return new BuggySSNHelperIncorrectFormat();
    //return new BuggySSNHelperIncorrectFormatFalse();
    //return new BuggySSNHelperMessyLuhn();
    //return new BuggySSNHelperWrongLength();
    //return new MyBuggySSNHelperAllow13Months();
    //return new MyBuggySSNHelperAllow32Days();
    //return new MyBuggySSNHelperAllowDay0();
  }

  @BeforeEach 
    public void setUp() {
      helper = createHelper();
    }

  @Test
  @DisplayName("isValidDay should return true for 31 days in a month")
  void isValidDay_ShouldReturnTrue_For_ThirtyoneDays() {
    assertTrue(helper.isValidDay("31"));
  }

  @Test
  @DisplayName("isValidMonth should return false for month 0")
  void isValidMonth_ShouldReturnFalse_MonthZeroDoesNotExist() {
    assertFalse(helper.isValidMonth("0"));
  }

  @Test
  @DisplayName("isCorrectFormat should return true for format XXXXXX-XXXX")
  void isCorrectFormat_ShouldReturnTrue_For_ValidFormat() {
    assertTrue(helper.isCorrectFormat("900101-0017"));
  }

  @Test
  @DisplayName("isCorrectFormat should return false for format XXXXXXXXXX")
  void isCorrectFormat_ShouldReturnFalse_For_InvalidFormat() {
    assertFalse(helper.isCorrectFormat("9001010017"));
  }

  @Test
  @DisplayName("luhnIsCorrect should return true for correct Luhn algorithm")
  void luhnIsCorrect_ShouldReturnTrue_For_CorrectLuhnAlgorithm() {
    String validSSN = "900101-0017";
    assertTrue(helper.luhnIsCorrect(validSSN));
  }

  @Test
  @DisplayName("isCorrectLength should return false for too many characters")
  void isCorrectLength_ShouldReturnFalse_For_SSNWithTooManyCharacters() {
    String invalidSSN = "900101-00178";
    assertFalse(helper.isCorrectLength(invalidSSN));
  }

  // <------- Additional tests for better coverage ------->
  @ParameterizedTest
  @ValueSource(strings = {"1", "6", "12"})
  @DisplayName("isValidMonth should return true for valid month range")
  void isValidMonth_ShouldReturnTrue_For_ValidMonths(String month) {
    assertTrue(helper.isValidMonth(month));
  }

  @ParameterizedTest
  @ValueSource(strings = {"-1", "0", "13"})
  @DisplayName("isValidMonth should return false for invalid month range")
  void isValidMonth_ShouldReturnFalse_For_InvalidMonths(String month) {
    assertFalse(helper.isValidMonth(month));
  }

  @ParameterizedTest
  @ValueSource(strings = {"0", "32"})
  @DisplayName("isValidDay should return false for invalid days")
  void isValidDay_ShouldReturnFalse_For_InvalidDays(String day) {
    assertFalse(helper.isValidDay(day));
  }
}
