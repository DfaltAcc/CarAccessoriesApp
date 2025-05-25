package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Admin create(@RequestBody Admin admin) {
        return service.save(admin);
    }

    @GetMapping("/read/{name}")
    public Admin read(@PathVariable String name) {
        return service.findByName(name);
    }

    @PutMapping("/update")
    public Admin update(@RequestBody Admin admin) {
        return service.save(admin);
    }
}
