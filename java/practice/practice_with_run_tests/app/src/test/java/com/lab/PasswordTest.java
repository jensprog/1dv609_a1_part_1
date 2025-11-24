package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Password implementations.
 * 
 * To test different buggy versions, simply uncomment the corresponding
 * getPassword() method and comment out the others.
 * 
 * Available implementations:
 * - Password: Correct implementation
 * - BugDoesNotTrim: Does not trim whitespace
 * - BugToShortPassword: Allows passwords shorter than 12 characters
 * - BugVeryShort: Allows way to short passwords
 * - BugWrongExceptionMessage: Wrong exception message for short passwords
 * - BugMissingPasswordLengthCheck: Does not throw exception for short passwords
 * - BugMissingNumberCheck: Does not throw exception if password lacks a number
 * - BugIsPasswordSameAlwaysTrue: isPasswordSame always returns true
 * - BugWrongHashingAlgorithm: Wrong hashing algorithm
 */

public class PasswordTest {
    private IPassword getPassword(String s) throws Exception {
        // return (IPassword) new Password(s);
        // return (IPassword) new BugDoesNotTrim(s);
        // return (IPassword) new BugToShortPassword(s);
        // return (IPassword) new BugToShortPassword(s);
        // return (IPassword) new BugVeryShort(s);
        // return (IPassword) new BugWrongExceptionMessage(s);
        // return (IPassword) new BugMissingPasswordLengthCheck(s);
        // return (IPassword) new BugMissingNumberCheck(s);
        // return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
        // return (IPassword) new BugWrongHashingAlgorithm(s);
    }

    @Test
    public void shouldAlwaysPass() throws Exception {
      assertTrue(true);
    }

    @Test
    @DisplayName("isPasswordSame should return true if trim is correctly implemented")
    void isPasswordSame_ShouldReturnTrue_ForTrimmedAndUntrimmedInput() throws Exception {
      IPassword password1 = getPassword("somepassword1");
      IPassword password2 = getPassword(" somepassword1 ");
      assertTrue(password1.isPasswordSame(password2));
    }

    @Test
    @DisplayName("isToShort should throw an exception if the password is too short")
    void isToShort_ShouldThrowExceptionFor_TooShortPassword() {
      assertThrows(Exception.class, () -> getPassword("password123"));
    }

    @Test
    @DisplayName("isToShort should throw an exception message 'Too short password'")
    void isToShort_ShouldThrowExceptionMessage_TooShortPassword() {
      Exception exception = assertThrows(Exception.class, () -> getPassword("hello"));
      assertEquals("Too short password", exception.getMessage());
    }

    @Test
    @DisplayName("containsNumber should throw an exception if the password is missing a number")
    void containsNumber_ShouldThrowExceptionFor_DoesNotContainANumber() {
      assertThrows(Exception.class, () -> getPassword("passwordxxxx"));
    }

    @Test
    @DisplayName("isPasswordSame should return false if the passwords are not the same")
    void isPasswordSame_ShouldReturnFalse_ForDifferentPasswords() throws Exception {
        IPassword password1 = getPassword("password12345");
        IPassword password2 = getPassword("password123456");
        assertFalse(password1.isPasswordSame(password2));
    }

    @ParameterizedTest
    @MethodSource("differentPasswordPairs")
    @DisplayName("simpleHash should create different hash values if the hashing algorithm is correct")
    void simpleHash_ShouldCreateDifferentHashValues_ForDifferentPasswords(String password1, String password2) throws Exception {
      IPassword pw1 = getPassword(password1);
      IPassword pw2 = getPassword(password2);
      assertNotEquals(pw1.getPasswordHash(), pw2.getPasswordHash());
    }
    
    static Stream<Arguments> differentPasswordPairs() {
      return Stream.of(
        Arguments.of("password1234", "password12345"),
        Arguments.of("password123456", "password1234567"),
        Arguments.of("password12345678", "password123456789"));
    }
}
