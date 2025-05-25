package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return service.save(user);
    }

    @GetMapping("/read/{name}")
    public User read(@PathVariable String name) {
        return service.findByName(name);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return service.save(user);
    }
}
