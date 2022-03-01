package car_service.config;

import car_service.data.entity.User;
import car_service.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbInit implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    /*@Autowired
    private PasswordEncoder encoder;*/

    public DbInit() {
    }

    public DbInit(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        //this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.userRepository.deleteAll();
//        User user = new User();
//        user.setUsername("user");
//        user.setPassword("1234");
//        user.setAccountNonExpired(true);
//        user.setAccountNonLocked(true);
//        user.setEnabled(true);
//        user.setCredentialsNonExpired(true);
//
//        User user2 = new User();
//        user2.setUsername("teacher");
//        user2.setPassword("1234");
//        user2.setAccountNonExpired(true);
//        user2.setAccountNonLocked(true);
//        user2.setEnabled(true);
//        user2.setCredentialsNonExpired(true);
//
//        List<User> users = Arrays.asList(user, user2);
//
//        // Save to db
//        this.userRepository.saveAll(users);
    }
}