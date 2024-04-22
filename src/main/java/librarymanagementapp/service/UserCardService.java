package librarymanagementapp.service;
/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Larysa Petrova
 * @version 17-Apr-24
 */

import librarymanagementapp.UserCard;
import librarymanagementapp.entity.User;
import librarymanagementapp.repository.UserCardRepository;

import java.util.Map;

public class UserCardService {
    private UserCardRepository repository;

    public UserCardService(UserCardRepository repository) {
        this.repository = repository;

    }

    public void addNewUserCard(UserCard userCard) {
        repository.put(userCard.getUserId(), userCard.getUser());
    }

    public void findUserCardByName(String name) {
        boolean found = false;
        for (User userCard : repository.values()) {
            if (userCard.getUser().getName().equalsIgnoreCase(name)) {
                System.out.println(userCard);
                found = true;
            }
        }
        if (!found) {
            System.out.println("User card with name \"" + name + "\"is not found!");
        }
    }

    public void findUserCardById(int userId) {
        User userCard = repository.get(userId);
        if (userCard != null) {
            System.out.println("User card found! " + userCard);
        } else {
            System.out.println("UserCard with ID " + userId + "not found");
        }
    }

    public boolean closeUserCard(int userId) {
        User userCard = repository.get(userId);
        if (userCard != null) {
            userCard.closeCard();
            return true;
        } else {
            System.out.println("UserCard with ID " + userId + "not found.");
            return false;
        }
    }

    public void reopenUserCard(int userId) {
        User userCard = repository.get(userId);
        if (userCard != null) {
            userCard.reopenCard();
            System.out.println("UserCard wiht Id" + userId + "reopened.");
        } else {
            System.out.println("UserCard with ID " + userId + "not found.");
        }
    }
}
