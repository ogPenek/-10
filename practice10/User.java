import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String password;
    private LocalDateTime lastLoginDate;
    private boolean isLoggedIn;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isLoggedIn = false;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public boolean isLoggedIn() { return isLoggedIn; }

    public void setLoggedIn(boolean loggedIn) { isLoggedIn = loggedIn; }
    public void setLastLoginDate(LocalDateTime lastLoginDate) { this.lastLoginDate = lastLoginDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); 
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Login: " + name + " | Online: " + isLoggedIn;
    }
}