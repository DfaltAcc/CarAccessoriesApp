package za.ac.cput.factory;

import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class ProductFactoryTest {

    @Test
    void testCreateProduct() {
        Product product = ProductFactory.createProduct(
                "Alloy Rim X-Series",
                "RimTek",
                "18-inch",
                "Aluminum",
                3200.00,
                25,
                "Durable lightweight alloy rim perfect for sports cars.",
                "https://images.app.goo.gl/vAyctM8o8DxCXzAB8"
        );

        assertNotNull(product);
        assertEquals("RimTek", product.getBrand());
        assertEquals("Alloy Rim X-Series", product.getName());
        assertEquals("18-inch", product.getSize());
        assertEquals("Aluminum", product.getMaterial());
        assertEquals(3200.00, product.getPrice());
        assertEquals(25, product.getStockQuantity());
        assertEquals("Durable lightweight alloy rim perfect for sports cars.", product.getDescription());
        assertEquals("https://images.app.goo.gl/vAyctM8o8DxCXzAB8", product.getImageUrl());

        System.out.println(product);
    }

}