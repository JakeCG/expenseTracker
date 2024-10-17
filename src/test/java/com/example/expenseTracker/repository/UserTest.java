package com.example.expenseTracker.repository;

import com.example.expenseTracker.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class UserTest {

    @Mock
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testUser = new User("testUsername", "password", "email@example.com");
    }

    @Test
    void testFindById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));

        Optional<User> foundUser = userRepository.findById(1L);

        assertTrue(foundUser.isPresent());
        assertEquals("testUsername", foundUser.get().getUsername());
        assertEquals("email@example.com", foundUser.get().getEmail());
        assertEquals("password", foundUser.get().getPassword());
    }

    @Test
    void findByUsername() {
        when(userRepository.findByUsername("testUsername")).thenReturn(Optional.of(testUser));

        Optional<User> foundUser = userRepository.findByUsername("testUsername");

        assertTrue(foundUser.isPresent());
        assertEquals("email@example.com", foundUser.get().getEmail());
        assertEquals("password", foundUser.get().getPassword());
    }
    @Test
    void findByEmail() {
        when(userRepository.findByEmail("email@example.com")).thenReturn(Optional.of(testUser));

        Optional<User> foundUser = userRepository.findByEmail("email@example.com");

        assertTrue(foundUser.isPresent());
        assertEquals("testUsername", foundUser.get().getUsername());
        assertEquals("password", foundUser.get().getPassword());
    }
}
