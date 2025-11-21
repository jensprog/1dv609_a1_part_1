package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

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
        return (IPassword) new Password(s);
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
    @DisplayName("Should return true if trim is correctly implemented")
    void isPasswordSame_ShouldReturnTrue_ForTrimmedAndUntrimmedInput() throws Exception {
      IPassword password1 = getPassword("somepassword1");
      IPassword password2 = getPassword(" somepassword1 ");
      assertTrue(password1.isPasswordSame(password2));
    }

    @Test
    @DisplayName("Should throw an exception if the password is too short")
    void isToShort_ShouldThrowExceptionFor_TooShortPassword() {
      assertThrows(Exception.class, () -> getPassword("password123"));
    }

    @Test
    @DisplayName("Should throw an exception message 'Too short password'")
    void isToShort_ShouldThrowExceptionMessage_TooShortPassword() {
      Exception exception = assertThrows(Exception.class, () -> getPassword("hello"));
      assertEquals("Too short password", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw an exception if the password is missing a number")
    void containsNumber_ShouldThrowExceptionFor_DoesNotContainANumber() {
      assertThrows(Exception.class, () -> getPassword("passwordxxxx"));
    }

    @Test
    @DisplayName("Should return false if the passwords are not the same")
    void isPasswordSame_ShouldReturnFalse_ForDifferentPasswords() throws Exception {
        IPassword password1 = getPassword("password12345");
        IPassword password2 = getPassword("password123456");
        assertFalse(password1.isPasswordSame(password2));
    }
}
