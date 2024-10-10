package com.example.expenseTracker.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("testuser", "password123", "test@example.com");
    }

    @Test
    void testUserConstructorValid() {
        assertNotNull(user);
        assertEquals("testuser", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals("test@example.com", user.getEmail());
        assertNotNull(user.getCreatedAt());
    }

    @Test
    void testUserConstructorInvalidUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new User(null, "password123", "test@example.com"));
        assertEquals("Username cannot be null or empty", exception.getMessage());
    }

    @Test
    void testUserConstructorInvalidPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new User("testuser", "pass", "test@example.com"));
        assertEquals("Password must be at least 6 characters long", exception.getMessage());
    }

    @Test
    void testUserConstructorInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new User("testuser", "password123", "invalid-email"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testSetUsernameValid() {
        user.setUsername("newusername");
        assertEquals("newusername", user.getUsername());
    }

    @Test
    void testSetUsernameInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> user.setUsername(""));
        assertEquals("Username cannot be null or empty", exception.getMessage());
    }

    @Test
    void testSetPasswordValid() {
        user.setPassword("newpassword123");
        assertEquals("newpassword123", user.getPassword());
    }

    @Test
    void testSetPasswordInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> user.setPassword("123"));
        assertEquals("Password must be at least 6 characters long", exception.getMessage());
    }

    @Test
    void testSetEmailValid() {
        user.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", user.getEmail());
    }

    @Test
    void testSetEmailInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> user.setEmail("invalid-email"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testSetCategoriesValid() {
        user.setCategories(new HashSet<>());
        assertNotNull(user.getCategories());
    }

    @Test
    void testSetCategoriesInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> user.setCategories(null));
        assertEquals("Categories cannot be null", exception.getMessage());
    }

    @Test
    void testSetExpensesValid() {
        user.setExpenses(new HashSet<>());
        assertNotNull(user.getExpense());
    }

    @Test
    void testSetExpensesInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> user.setExpenses(null));
        assertEquals("Expenses cannot be null", exception.getMessage());
    }
}
