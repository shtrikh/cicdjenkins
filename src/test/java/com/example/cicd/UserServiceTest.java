package service;

import static org.junit.jupiter.api.Assertions.*;

import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testGetUserById() {
        User user = userService.createUser("Jane Smith", "jane@example.com");
        long userId = user.getId();

        User retrievedUser = userService.getUserById(userId);

        assertNotNull(retrievedUser);
        assertEquals(userId, retrievedUser.getId());
        assertEquals("Jane Smith", retrievedUser.getName());
        assertEquals("jane@example.com", retrievedUser.getEmail());
    }
}
