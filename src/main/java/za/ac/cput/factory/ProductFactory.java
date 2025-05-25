package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class ProductFactory {
    public static Product createProduct(String name, String brand, String size,String material, double price, int stockQuality,  String description, String imageUrl) {


        if (Helper.isNullOrEmpty(name)
                || Helper.isNullOrEmpty(brand)
                || Helper.isNullOrEmpty(size)
                || Helper.isNullOrEmpty(material)
                || Helper.isNullOrEmpty(description)
                || Helper.isNullOrEmpty(imageUrl)) {
            return null;
        }

//        if (price <= 0 || stockQuantity < 0) {
//            return null;
//        }

        String productId = Helper.generateId();


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
