package com.example.expenseTracker.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category("Groceries");
    }

    @Test
    void testConstructorValidName() {
        assertEquals("Groceries", category.getName());
        assertNotNull(category.getCreatedAt());
    }

    @Test
    void testConstructorInvalidNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Category(null));
        assertThrows(IllegalArgumentException.class, () -> new Category(""));
        assertThrows(IllegalArgumentException.class, () -> new Category("   "));
    }

    @Test
    void testGetId() {
        long expectedId = 1L;
        category.setID(expectedId);
        assertEquals(expectedId, category.getID());
    }

    @Test
    void testSetID() {
        long newId = 2L;
        category.setID(newId);
        assertEquals(newId, category.getID());
    }

    @Test
    void testGetUser() {
        User user = new User("testUser", "password123", "test@example.com");
        category.setUser(user);
        assertEquals(user, category.getUser());
    }

    @Test
    void testSetUser() {
        User user = new User("testUser", "password123", "test@example.com");
        category.setUser(user);
        assertEquals(user, category.getUser());
    }

    @Test
    void testGetName() {
        assertEquals("Groceries", category.getName());
    }

    @Test
    void testSetNameValid() {
        String newName = "Utilities";
        category.setName(newName);
        assertEquals(newName, category.getName());
    }

    @Test
    void testSetNameInvalidThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> category.setName(null));
        assertThrows(IllegalArgumentException.class, () -> category.setName(""));
        assertThrows(IllegalArgumentException.class, () -> category.setName("   "));
    }

    @Test
    void testGetCreatedAt() {
        assertNotNull(category.getCreatedAt());
    }

    @Test
    void testSetExpensesValid() {
        Set<Expense> expenses = new HashSet<>();
        Expense expense1 = new Expense(new BigDecimal("100.00"), "Milk");
        Expense expense2 = new Expense(new BigDecimal("100.00"), "Eggs");
        expenses.add(expense1);
        expenses.add(expense2);

        category.setExpenses(expenses);
        assertEquals(2, category.getExpenses().size());
        assertTrue(category.getExpenses().contains(expense1));
        assertTrue(category.getExpenses().contains(expense2));
    }
}
