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
    private String imageUrl;

    private Product(){}

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.brand = builder.brand;
        this.size = builder.size;
        this.material = builder.material;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.description = builder.description;
        this.imageUrl = builder.imageUrl;

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

    public String getImageUrl() {
        return imageUrl;
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
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public static class Builder {
        private String productId;
        private String name;
        private String brand;
        private String size;
        private String material;
        private double price;
        private int stockQuantity;
        private String description;
        private String imageUrl;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setSize(String size) {
            this.size = size;
            return this;
        }
        public Builder setMaterial(String material) {
            this.material = material;
            return this;
        }
        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }
        public Builder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder copy(Product product) {
            this.productId = product.productId;
            this.name = product.name;
            this.brand = product.brand;
            this.size = product.size;
            this.material = product.material;
            this.price = product.price;
            this.stockQuantity = product.stockQuantity;
            this.description = product.description;
            this.imageUrl = product.imageUrl;
            return this;
        }
        public Product build() {
            return new Product(this);
        }
    }
}
