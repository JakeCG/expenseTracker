package com.example.expenseTracker.repository;

import com.example.expenseTracker.model.Category;
import com.example.expenseTracker.model.Expense;
import com.example.expenseTracker.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ExpenseTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByUser_Id() {
        Long userId = 1L;
        User user = new User("username", "password", "email@example.com");
        Category category1 = new Category("Food");
        Category category2 = new Category("Drinks");
        Expense expense1 = new Expense(new BigDecimal("100.00"), "Lorem ipsum 1");
        Expense expense2 = new Expense(new BigDecimal("200.00"), "Lorem ipsum 2");

        category1.setUser(user);
        category2.setUser(user);
        expense1.setCategory(category1);
        expense2.setCategory(category2);

        List<Expense> mockExpenses = new ArrayList<>();
        mockExpenses.add(expense1);
        mockExpenses.add(expense2);

        when(expenseRepository.findByUser_Id(userId)).thenReturn(mockExpenses);

        List<Expense> result = expenseRepository.findByUser_Id(userId);

        assertEquals(2, result.size());
        assertEquals(new BigDecimal("100.00"), result.get(0).getAmount());
        assertEquals("Lorem ipsum 1", result.get(0).getDescription());
        assertEquals(category1, result.get(0).getCategory());
        assertEquals(new BigDecimal("200.00"), result.get(1).getAmount());
        assertEquals("Lorem ipsum 2", result.get(1).getDescription());
        assertEquals(category2, result.get(1).getCategory());
    }

    @Test
    void testFindByCategory_Id() {
        Long categoryId = 1L;
        User user = new User("username", "password", "email@example.com");
        Category category1 = new Category("Food");
        category1.setID(categoryId);
        Category category2 = new Category("Drinks");
        Expense expense1 = new Expense(new BigDecimal("100.00"), "Lorem ipsum 1");
        Expense expense2 = new Expense(new BigDecimal("200.00"), "Lorem ipsum 2");
        Expense expense3 = new Expense(new BigDecimal("300.00"), "Lorem ipsum 3");
        Expense expense4 = new Expense(new BigDecimal("400.00"), "Lorem ipsum 4");

        category1.setUser(user);
        category2.setUser(user);
        expense1.setCategory(category1);
        expense2.setCategory(category1);
        expense3.setCategory(category2);
        expense4.setCategory(category2);

        List<Expense> mockExpenses = new ArrayList<>();
        mockExpenses.add(expense1);
        mockExpenses.add(expense2);

        when(expenseRepository.findByCategory_Id(categoryId)).thenReturn(mockExpenses);

        List<Expense> result = expenseRepository.findByCategory_Id(categoryId);

        assertEquals(2, result.size());
        assertEquals(new BigDecimal("100.00"), result.get(0).getAmount());
        assertEquals("Lorem ipsum 1", result.get(0).getDescription());
        assertEquals(new BigDecimal("200.00"), result.get(1).getAmount());
        assertEquals("Lorem ipsum 2", result.get(1).getDescription());
        assertEquals(category1, result.get(0).getCategory());
        assertEquals(category1, result.get(1).getCategory());
    }
}
