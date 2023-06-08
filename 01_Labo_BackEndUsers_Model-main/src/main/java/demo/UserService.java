package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
     private UserRepository userRepository;

    public UserService() {
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
        }

        public List<User> getUsersWithAgeOlderThan(int age) {
            return userRepository.findUsersByAgeAfter(age);
            }

            public User getOldestUser() {
                return userRepository.getOldestUser();
            }

            public User getUserWithName(String name) {
                return userRepository.findUserByName(name);
            }

    public boolean addUser(User user) {
        if (getUserWithEmail(user.getEmail()) != null)
         return false;
        userRepository.save(user);
        return true;
    }

    public User getUserWithEmail(String email) {
        return userRepository.findUserByEmail(email);
       }

       public User removeUser(String email) {
        User userToRemove = userRepository.findUserByEmail(email);
        if (userToRemove != null) {
            userRepository.delete(userToRemove);
        }
        return userToRemove;
    }

    public List<User> getUsersWithEmailAndAge(String email, int age) {
        return userRepository.findUsersByEmailAndAge(email, age);
    }

    public List<User> getUsersWithAgeBetweenMinMax(int minage, int maxage) {
        return userRepository.findUsersByAgeBetween(minage, maxage);
    }

    
}
