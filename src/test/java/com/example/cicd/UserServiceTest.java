package com.example.cicd;


import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserService userServiceUnderTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        when(userService.createUser("John Doe", "john@example.com")).thenReturn(new User(1, "John Doe", "john@example.com"));

        User user = userServiceUnderTest.createUser("John Doe", "john@example.com");

        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
    }

}
