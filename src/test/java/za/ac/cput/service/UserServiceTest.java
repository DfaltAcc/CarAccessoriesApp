package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    private User user = UserFactory.createUser("77T", "lee03",
            "Lennox", "875555", "lee@nnox", "Admin", "001AD");

    @Test
    @Order(1)
    void create() {
        User created =userService.save(user);
        assertNotNull(created);
        System.out.println(created);

    }

    @Test
    @Order(2)
    void read() {

        User read = userService.findByName(user.getName());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void c_update() {
        User newUser = new User.Builder().copy(user).setUserID("yyy6").build();
        User upudate = userService.save(newUser);
        assertNotNull(upudate);
        System.out.println(upudate);

    }

    @Test
    @Disabled
    @Order(4)
    void delete() {
       User saved = userService.save(user); // Ensure customer is saved
        assertNotNull(saved); // Sanity check


    }
}