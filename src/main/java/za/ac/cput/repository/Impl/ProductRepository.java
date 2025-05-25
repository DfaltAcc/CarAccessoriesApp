package za.ac.cput.repository.Impl;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Product findProductByName(String name);

    Optional<Product> findProductByModel(String model);

    List<Product> findAllByProductId(String productId);

}
