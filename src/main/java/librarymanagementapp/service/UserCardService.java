package librarymanagementapp;
/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Larysa Petrova
 * @version 17-Apr-24
 */

import librarymanagementapp.entity.User;
import librarymanagementapp.service.BookCatalogService;

import java.util.HashMap;
import java.util.Map;

public class UserCardService {
    private Map<Integer, UserCard> userCards;

    public UserCardService() {
        BookCatalogService bookCatalog = new BookCatalogService();
        userCards = new HashMap<>();
    }

    /**
     * @param user
     * @param limit
     */
    public void addNewUserCard(User user, int limit) {
        if (!userCards.containsKey(user.getUserId())) {
            UserCard userCard = new UserCard(user.getName(), user.getUserId(), limit);
            userCard.put(user.getUserId(), userCard);
            System.out.println("User card created successfully for user: " + user.getName());
        } else {
            System.out.println("User card already exists for user: " + user.getName());
        }
    }

    public boolean closeUserCard(int userId) {
        if (userCards.containsKey(userId)) {
            userCards.remove(userId);
            System.out.println("User card closed successfully for user ID: " + userId);
            return true;
        } else {
            System.out.println("User card not found for user ID: + userId");
            return false;
        }
    }

    public void reopenUserCard(int userId) {
        if (userCards.containsKey(userId)) {
            UserCard userCard = userCards.get(userId);
            userCard.setClosed(false);
            System.out.println("User card reopened successfully for user ID: " + userId);
        } else {
            System.out.println("User card not found for user ID: " + userId);
        }
    }
}
