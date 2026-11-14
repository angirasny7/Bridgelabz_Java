package Exceptions.AdvancedExceptionHandling;
import java.util.HashSet;
import java.util.Set;
class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) { super(message); }
}
class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) { super(message); }
}
class UserService {
    private final Set<String> users = new HashSet<>();
    public UserService() { users.add("admin"); users.add("student"); }
    public void registerUser(String username) throws UserAlreadyExistsException {
        if (users.contains(username))
            throw new UserAlreadyExistsException("User already exists: " + username);
        users.add(username);
        System.out.println("User registered successfully: " + username);
    }
    public void checkUserExistence(String username) throws UserNotFoundException {
        if (!users.contains(username))
            throw new UserNotFoundException("User not found: " + username);
        System.out.println("User exists: " + username);
    }
}
public class UserServiceExceptionDemo {
    /*
     * Problem: Demonstrate custom exceptions for duplicate and missing users.
     * Register a user and check whether a username exists.
     */
    public static void main(String[] args) {
        UserService service = new UserService();
        try {
            service.registerUser("admin");
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        try {
            service.checkUserExistence("guest");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            service.registerUser("newUser");
            service.checkUserExistence("newUser");
        } catch (UserAlreadyExistsException | UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
