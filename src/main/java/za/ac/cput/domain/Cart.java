package za.ac.cput.domain;

public class Cart {
    private String cartId;
    private long dateCreated;

    public Cart() {
    }
     public Cart (Builder builder) {
        this.cartId = builder.cartId;
        this.dateCreated = builder.dateCreated;}

    public Cart(String cartId, long dateCreated) {
        this.cartId = cartId;
        this.dateCreated = dateCreated;
    }

    public String getCartId() {
        return cartId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public long getDateCreated() {
        return dateCreated;

    }
    public static class Builder {
        private String cartId;
        private long dateCreated;

        public Builder setCartId(String cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setDateCreated(long dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }
        public Builder copy(Cart cart) {
            this.cartId = cart.cartId;
            this.dateCreated = cart.dateCreated;
            return this;
        }

        public Cart build() {
            return new Cart(cartId, dateCreated);

        }
    }
}
