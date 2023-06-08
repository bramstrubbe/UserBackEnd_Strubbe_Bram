package demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@CrossOrigin(origins = "http://127.0.0.1:5000")
@RestController
@RequestMapping("/users")

public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/oldest")
    public User getOldestUser() {
        return userService.getOldestUser();
    }

    @GetMapping("/search/olderthan")
    public List<User> searchUsersWithAgeOlderThan(@RequestParam("age") int age) {
        return userService.getUsersWithAgeOlderThan(age);
    }

    @GetMapping("/search/{name}")
    public User searchUserWithName(@PathVariable("name") String name) {
        return userService.getUserWithName(name);
    }

    @GetMapping("/adults")
    public List<User> getAdultsUser() {
        return userService.getUsersWithAgeOlderThan(17);
    }
    @GetMapping("/search/email/{email}")
    public User searchUserWithEmail(@PathVariable("email") String email) 
    { 
        return userService.getUserWithEmail(email);}
    
    @GetMapping("/search")
        public List<User> searchUserWithEmailAndAge(@RequestParam("email") String email ,@RequestParam("age") int age) {
        return userService.getUsersWithEmailAndAge(email,age);
    }

    @GetMapping("/search/age/{min}/{max}")
    public List<User> searchUsersWithAgeOlderThan(@PathVariable("min") int Minage, @PathVariable("max") int Maxage) {
        return userService.getUsersWithAgeBetweenMinMax(Minage, Maxage);
    }

   

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*");
    }
}
    

}

