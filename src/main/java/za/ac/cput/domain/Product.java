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

    public Product(){}

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.brand = builder.brand;
        this.size = builder.size;
        this.material = builder.material;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.description = builder.description;
        this.imageUml = builder.imageUml;

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

    public static class Builder {
        private String productId;
        private String name;
        private String brand;
        private String size;
        private String material;
        private double price;
        private int stockQuantity;
        private String description;
        private String imageUml;

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setImageUml(String imageUml) {
            this.imageUml = imageUml;
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
            this.imageUml = product.imageUml;
            return this;
        }
        public Product build() {
            return new Product(this);
        }
    }
}
