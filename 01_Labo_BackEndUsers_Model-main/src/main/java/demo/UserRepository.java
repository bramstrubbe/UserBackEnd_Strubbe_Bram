package demo;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

 public List<User> findUsersByAgeAfter(int age);
 public User findUserByEmail(String email);
public User getOldestUser();
public User findUserByName(String name);
public List<User> findUsersByEmailAndAge(String email, int age);
public List<User> findUsersByAgeBetween(int minage, int maxage);
public Object findAllByOrderByAgeDesc();

}