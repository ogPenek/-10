import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class UserRegistry {
    private Set<User> users = new HashSet<>();
    private int idCounter = 1; 

    public void registerUser(String login, String password) {
        User newUser = new User(idCounter++, login, password);
        if (!users.add(newUser)) { 
            System.out.println("Користувач [" + login + "] вже є у списку");
            idCounter--; 
        }
    }

    public void loginUser(String login, String password) {
        for (User u : users) {
            if (u.getName().equals(login) && u.getPassword().equals(password)) {
                u.setLoggedIn(true);
                u.setLastLoginDate(LocalDateTime.now());
                System.out.println("Вхід успішний!");
                return;
            }
        }
        System.out.println("Неможливо ідентифікувати або автентифікувати користувача");
    }

    public void logoutUser(int userId) {
        for (User u : users) {
            if (u.getId() == userId) {
                u.setLoggedIn(false);
                System.out.println("Користувач вийшов з системи");
                return;
            }
        }
    }

    public void removeUser(int id) {
        boolean removed = users.removeIf(u -> u.getId() == id);
    
        if (removed) {
        System.out.println("Користувача з ID " + id + " успішно видалено.");
    }   else {
        System.out.println("Користувача з ID " + id + " не знайдено.");
    }
    }

    public void displayAllUsers() {
        System.out.println("--- Список користувачів ---");
        for (User u : users) System.out.println(u);
    }
}