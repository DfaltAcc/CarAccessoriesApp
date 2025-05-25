package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.Impl.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private  ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public Optional<Product> findProductByModel(String model) {
        return productRepository.findProductByModel(model);
    }

    @Override
    public List<Product> findAllByProductId(String productId) {
        return productRepository.findAllByProductId(productId);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }


    @Override
    public Optional<Product> read(Product product) {
        return productRepository.findById(product.getProductId());
    }

    @Override
    public Product update(Product product) {
        if (productRepository.existsById(product.getProductId())) {
            return productRepository.save(product);
        }
        return null;
    }
}
