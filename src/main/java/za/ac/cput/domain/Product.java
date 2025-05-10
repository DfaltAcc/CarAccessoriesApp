package za.ac.cput.domain;

public class Product {
    private String productId;
    private String name;
    private String brand;
    private String size;
    private String material;
    private double price;
    private int stockQuantity;
    private String description;
    private String imageUml;


    public Product(String productId, String name, String brand, String size, String material, double price, int stockQuantity, String description, String imageUml) {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.material = material;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.imageUml = imageUml;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUml() {
        return imageUml;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", size='" + size + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", description='" + description + '\'' +
                ", imageUml='" + imageUml + '\'' +
                '}';
    }
}
