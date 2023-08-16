package service;


import model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<Long, User> users = new HashMap<>();
    private long nextUserId = 1;

    public User createUser(String name, String email) {
        User user = new User(nextUserId, email, email);
        users.put(nextUserId, user);
        nextUserId++;
        return user;
    }

    public User getUserById(long userId) {
        return users.get(userId);
    }
}

