package com.portfolio.my_stock_portfolio.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordServiceTest {

    private final PasswordService passwordService = new PasswordService();

    @Test
    public void testHashAndMatchPassword() {
        String plainPassword = "my_secure_password";
        String hashedPassword = passwordService.hashPassword(plainPassword);

        assertNotNull(hashedPassword);
        assertTrue(passwordService.matchPassword(plainPassword, hashedPassword));
    }

    @Test
    public void testInvalidPassword() {
        String plainPassword = "my_secure_password";
        String hashedPassword = passwordService.hashPassword(plainPassword);

        assertFalse(passwordService.matchPassword("wrong_password", hashedPassword));
    }
}
