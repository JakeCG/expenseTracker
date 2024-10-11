package com.example.expenseTracker.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ExpensesTest {
    private Expense expense;
    private User mockUser;
    private Category mockCategory;

    @BeforeEach
    public void setUp() {
        mockUser = mock(User.class);
        mockCategory = mock(Category.class);
        expense = new Expense(new BigDecimal("100.00"), "Test expense");
    }

    @Test
    public void testConstructorValidInput() {
        assertNotNull(expense);
        assertEquals(new BigDecimal("100.00"), expense.getAmount());
        assertEquals("Test expense", expense.getDescription());
        assertNotNull(expense.getCreatedAt());
    }

    @Test
    public void testConstructorInvalidAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Expense(null, "Test expense"));
        assertEquals("The amount can't be null or 0.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new Expense(BigDecimal.ZERO, "Test expense"));
        assertEquals("Amount must be greater than zero", exception.getMessage());
    }

    @Test
    public void testConstructorInvalidDescription() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Expense(new BigDecimal("100.00"), null));
        assertEquals("The description cannot be null or empty.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new Expense(new BigDecimal("100.00"), ""));
        assertEquals("The description cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void testSetUser() {
        expense.setUser(mockUser);
        assertEquals(mockUser, expense.getUser());
    }

    @Test
    public void testSetUserNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> expense.setUser(null));
        assertEquals("User cannot be null", exception.getMessage());
    }

    @Test
    public void testSetAmountValid() {
        expense.setAmount(new BigDecimal("150.00"));
        assertEquals(new BigDecimal("150.00"), expense.getAmount());
    }

    @Test
    public void testSetAmountInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> expense.setAmount(null));
        assertEquals("Amount must be greater than zero", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> expense.setAmount(BigDecimal.ZERO));
        assertEquals("Amount must be greater than zero", exception.getMessage());
    }

    @Test
    public void testSetDescriptionValid() {
        expense.setDescription("New description");
        assertEquals("New description", expense.getDescription());
    }

    @Test
    public void testSetDescriptionInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> expense.setDescription(null));
        assertEquals("Description cannot be null or empty", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> expense.setDescription(""));
        assertEquals("Description cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testSetCategory() {
        expense.setCategory(mockCategory);
        assertEquals(mockCategory, expense.getCategory());
    }

    @Test
    public void testSetCategoryNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> expense.setCategory(null));
        assertEquals("Category cannot be null", exception.getMessage());
    }
}
