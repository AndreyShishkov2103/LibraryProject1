package librarymanagementapp.service;
/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Larysa Petrova
 * @version 17-Apr-24
 */

import librarymanagementapp.UserCard;
import librarymanagementapp.entity.User;

import java.util.Map;

public class UserCardService {
    private Map<Integer, UserCard> userCards;

    public UserCardService(Map<Integer, UserCard> userCards) {
        this.userCards = userCards;
    }

    public void addNewUserCard(User user, int limit) {
        UserCard newUserCard = new UserCard(user);
        userCards.put(user.getUserId(), newUserCard);
    }

    public void findUserCardByName(String name) {
        boolean found = false;
        for (UserCard card : userCards.values()) {
            if (card.getUser().getName().equalsIgnoreCase(name)) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("User card with name \"" + name + "\"is not found!");
        }
    }

    public void findUserCardById(int userId) {
        UserCard userCard = userCards.get(userId);
        if (userCard != null) {
            System.out.println("User card found! " + userCard);
        } else {
            System.out.println("UserCard with ID " + userId + "not found");
        }
    }

    public boolean closeUserCard(int userId) {
        UserCard userCard = userCards.get(userId);
        if (userCard != null) {
            userCard.closeCard();
            return true;
        } else {
            System.out.println("UserCard with ID " + userId + "not found.");
            return false;
        }
    }

    public void reopenUserCard(int userId) {
        UserCard userCard = userCards.get(userId);
        if (userCard != null) {
            //Implement reopening logic here
            System.out.println("UserCard wiht Id" + userId + "reopened.");
        } else {
            System.out.println("UserCard with ID " + userId + "not found.");
        }
    }
}
