package com.example.expenseTracker.repository;

import com.example.expenseTracker.model.Category;
import com.example.expenseTracker.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CategoryTest {

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByUser_Id() {
        Long userId = 1L;
        User user = new User("username", "password", "email@example.com");
        Category category1 = new Category("Food");
        Category category2 = new Category("Travel");

        category1.setUser(user);
        category2.setUser(user);

        List<Category> mockCategories = new ArrayList<>();
        mockCategories.add(category1);
        mockCategories.add(category2);

        when(categoryRepository.findByUser_Id(userId)).thenReturn(mockCategories);

        List<Category> result = categoryRepository.findByUser_Id(userId);

        assertEquals(2, result.size());
        assertEquals("Food", result.get(0).getName());
        assertEquals("Travel", result.get(1).getName());
    }
}
