package maria.incyberspace.Lesson10;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class UserMapTask {
    public static void main(String[] args) {
        // Needed to get user input
        Scanner scanner = new Scanner(System.in);
        // Create some new users
        UserMap userMap = new UserMap();
        userMap.generateUserMap();
        // Let's see who's on the list
        System.out.println(userMap.getUserMap());
        // Enter a name whose points we wish to check
        System.out.println("Please enter the name: ");
        String input = scanner.nextLine(); // Store the input in a variable
        // Find user by their name
        User found = userMap.findUser(input);
        // Log the results to the console
        System.out.println("User " + found.getName() + " found. Points: " + userMap.getUserMap().get(found));
    }


}
// This class has a functionality of generating a map of users, allowing to view it and find a User in it by name
class UserMap {
    private Map<User, Integer> userMap = new HashMap<>();

    public void addUserToMap(User user, int points) {
        userMap.put(user, points);
    }
    public Map<User, Integer> getUserMap() {
        return userMap;
    }

    public User findUser(String name) {
        try {
            User user;
            for (int i = 0; i < userMap.size(); i++) {
                user = (User)userMap.keySet().toArray()[i];
                if (name.equals(user.getName())) {
                    return user;
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("User with name" + name + " wasn't found. " + ex.getMessage());
        }
        return null;
    }

    public Map<User, Integer> generateUserMap() {
        // Random random = new Random();
        String[] names = { "Bob", "Stella", "Steve", "Michael", "Kyoko"};
        Map<User, Integer> userMap = new HashMap<>();
        int[] points = { 54, 89, 90, 76, 84 };
        for (int i = 0; i < names.length; i++) {
           // userMap.put(new User(names[random.nextInt(names.length)]), points[random.nextInt(points.length)]);
            userMap.put(new User(names[i]), points[i]);
        }
        this.userMap = userMap;
        return userMap;
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

