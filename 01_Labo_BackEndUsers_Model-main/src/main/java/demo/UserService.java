package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private List<User> userRepository = new ArrayList<>();

    public UserService() {
    }

    public List<User> getAllUsers() {
        return userRepository;
    }

    public List<User> getUsersWithAgeOlderThan(int age) {
        return userRepository.stream().filter(user -> user.getAge() > age).toList();
    }

    public User getOldestUser() {
        User oldest = null;
        if (userRepository.size() > 0) {
            oldest = userRepository.get(0);
            for (User user : userRepository) {
                if (user.getAge() > oldest.getAge())
                    oldest = user;
            }
        }
        return oldest;
    }

    public User getUserWithName(String name) {
        return userRepository.stream().filter(user -> user.getName().equals(name)).toList().get(0);
    }

    public boolean addUser(User user) {
        if (isEmailAlreadyUsed(user.getEmail())) {
            return false;
        }
        userRepository.add(user);

        return true;
    }

    private boolean isEmailAlreadyUsed(String email) {
        for (User user : userRepository) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public User getUserWithEmail(String email) {
        for (User user : userRepository) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User removeUser(String email) {
        User removedUser = null;
        for (User user : userRepository) {
            if (user.getEmail().equals(email)) {
                removedUser = user;
                userRepository.remove(user);
                break;
            }
        }
        return removedUser;
    }

    public List<User> getUsersWithEmailAndAge(String email, int age) {
        return userRepository.stream().filter(user -> user.getEmail().equals(email) && user.getAge() == age).toList();
    }

    public List<User> getUsersWithAgeBetweenMinMax(int minage, int maxage) {
        for (User user : userRepository) {
            if (user.getAge() >= minage && user.getAge() <= maxage) {
                userRepository.add(user);
            }
        }

        return userRepository;
    }

}
