package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.service.ProductService;

@RestController
@RequestMapping("/webcar")

public class ProductController {
    private ProductService service;

    @Autowired
    public void ProductController(ProductService service) {

        this.service = service;
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }


    @GetMapping("/read{name}")
    public Product read(@PathVariable String name) {
        return service.findProductByName(name);
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product) {
        return service.save(product);
    }
}
