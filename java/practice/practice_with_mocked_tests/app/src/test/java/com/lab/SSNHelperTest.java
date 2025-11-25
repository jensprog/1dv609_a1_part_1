package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class SSNHelperTest {

  private ISSNHelper helper;

  private ISSNHelper createHelper() {
    return new SSNHelper();
    // return new BuggySSNHelperAllowDayUpTo30();
    //return new BuggySSNHelperAllowMonth0();
    //return new BuggySSNHelperIncorrectFormat();
    //return new BuggySSNHelperIncorrectFormatFalse();
    //return new BuggySSNHelperMessyLuhn();
    //return new BuggySSNHelperWrongLength();
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
}
