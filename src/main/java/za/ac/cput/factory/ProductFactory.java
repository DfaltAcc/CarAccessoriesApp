package za.ac.cput.factory;

import za.ac.cput.domain.Product;

public class ProductFactory {
    public static Product createProduct(String name, String brand, String size,String material, double price, int stockQuality,  String description, String imageUrl) {

        return new Product.Builder()
                .setName(name)
                .setBrand(brand)
                .setSize(size)
                .setMaterial(material)
                .setPrice(price)
                .setStockQuantity(stockQuality)
                .setDescription(description)
                .setImageUrl(imageUrl)
                .build();



    }
}
