package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import static org.mockito.Mockito.*;

public class SwedishSocialSecurityNumberTest {
    
  private SSNHelper mockHelper;
    
  @BeforeEach
  public void setUp() {
    mockHelper = mock(SSNHelper.class);
  }
    
  @Test
  public void shouldAcceptValidSSN() throws Exception {
    when(mockHelper.isCorrectLength("900101-0017")).thenReturn(true);
    when(mockHelper.isCorrectFormat("900101-0017")).thenReturn(true);
    when(mockHelper.isValidMonth("01")).thenReturn(true);
    when(mockHelper.isValidDay("01")).thenReturn(true);
    when(mockHelper.luhnIsCorrect("900101-0017")).thenReturn(true);

    SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-0017", mockHelper);
        
    assertEquals("90", ssn.getYear());
    assertEquals("01", ssn.getMonth());
    assertEquals("01", ssn.getDay());
    assertEquals("0017", ssn.getSerialNumber());

    verify(mockHelper).isCorrectLength("900101-0017");
    verify(mockHelper).isCorrectFormat("900101-0017");
    verify(mockHelper).isValidMonth("01");
    verify(mockHelper).isValidDay("01");
    verify(mockHelper).luhnIsCorrect("900101-0017");
  }

  @Test
  @DisplayName("isCorrectLength should throw an exception for too short SSN")
  void isCorrectLength_ShouldThrowException_For_TooShortSSN() {
    when(mockHelper.isCorrectLength("900101-001")).thenReturn(false);
    when(mockHelper.isCorrectFormat("900101-001")).thenReturn(true);
    when(mockHelper.isValidMonth("01")).thenReturn(true);
    when(mockHelper.isValidDay("01")).thenReturn(true);
    when(mockHelper.luhnIsCorrect("900101-001")).thenReturn(true);

    assertThrows(Exception.class, () -> {
      new SwedishSocialSecurityNumber("900101-001", mockHelper);
    });

    verify(mockHelper).isCorrectLength("900101-001");
  }

  @Test
  @DisplayName("luhnIsCorrect should throw an exception for incorrect algorithm")
  void luhnIsCorrect_ShouldThrowException_For_IncorrectAlgorithm() {
    when(mockHelper.isCorrectLength("900101-0017")).thenReturn(true);
    when(mockHelper.isCorrectFormat("900101-0017")).thenReturn(true);
    when(mockHelper.isValidMonth("01")).thenReturn(true);
    when(mockHelper.isValidDay("01")).thenReturn(true);
    when(mockHelper.luhnIsCorrect("900101-0017")).thenReturn(false);

  assertThrows(Exception.class, () -> {
    new SwedishSocialSecurityNumber("900101-0017", mockHelper);
  });

  verify(mockHelper).luhnIsCorrect("900101-0017");
 }

 @Test
 @DisplayName("Should successfully create a valid SSN when the input has whitespaces (test trimming)")
 void createValidSSN_WithUntrimmedInput() throws Exception {
  when(mockHelper.isCorrectLength("900101-0017")).thenReturn(true);
  when(mockHelper.isCorrectFormat("900101-0017")).thenReturn(true);
  when(mockHelper.isValidMonth("01")).thenReturn(true);
  when(mockHelper.isValidDay("01")).thenReturn(true);
  when(mockHelper.luhnIsCorrect("900101-0017")).thenReturn(true);

  SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber(" 900101-0017 ", mockHelper);

  assertEquals("900101-0017", ssn.getSSN());
  verify(mockHelper).isCorrectLength("900101-0017");
 }

 @Test
 @DisplayName("Should return the correct year when calling getYear (test substring)")
 void createValidSSN_Scenario_ExpectedResult() throws Exception {
  when(mockHelper.isCorrectLength("900101-0017")).thenReturn(true);
  when(mockHelper.isCorrectFormat("900101-0017")).thenReturn(true);
  when(mockHelper.isValidMonth("01")).thenReturn(true);
  when(mockHelper.isValidDay("01")).thenReturn(true);
  when(mockHelper.luhnIsCorrect("900101-0017")).thenReturn(true);

  SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-0017", mockHelper);
  assertEquals("90", ssn.getYear());
  verify(mockHelper).isCorrectFormat("900101-0017");
 }
}