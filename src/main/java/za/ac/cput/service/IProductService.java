package za.ac.cput.service;

import za.ac.cput.domain.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService extends IService<Product, String>{
    Product findProductByName(String name);

    Optional<Product> findProductByModel(String model);

    List<Product> findAllByProductId(String productId);

}
