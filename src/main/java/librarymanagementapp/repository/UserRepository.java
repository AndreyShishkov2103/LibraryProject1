package librarymanagementapp.repository;
/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Larysa Petrova
 * @version 19-Apr-24
 **/

import librarymanagementapp.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private Map<Integer, User> users;

    public UserRepository() {
        users = new HashMap<>();
    }

    public void init() {
        List<User> usersList = new ArrayList<>(List.of(
                new User(1, "John", "Smith"),
                new User(2, "Sahar", "Jones"),
                new User(3, "Mihael", "Wilson"),
                new User(4, "Alexander", "Clack"),
                new User(5, "Emily", "Wilson")
        ));
        for (User user : usersList) {
            addUser(user);
        }
    }

    public Map<Integer, User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public User getUserById(int userId) {
        return users.get(userId);
    }

    public void updateUser(User user) {
        if (users.containsKey(user.getUserId())) {
            users.put(user.getUserId(), user);
        } else {
            System.out.println("User with ID " + user.getUserId() + "does not exist.");
        }
    }

    public void removeUser(int userId) {
        if (users.containsKey(userId)) {
            users.remove(userId);
        } else {
            System.out.println("User with ID " + userId + "does not exit.");
        }
    }
}
