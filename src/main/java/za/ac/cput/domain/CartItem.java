package za.ac.cput.domain;

public class CartItem {
    private String cartItemId;
    private int quantity;
    private double subtotal;

    public CartItem() {
    }
   public CartItem (Builder builder) {
        this.cartItemId = builder.cartItemId;
        this.quantity = builder.quantity;
        this.subtotal = builder.subtotal;}
    public String getCartItemId() {
        return cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId='" + cartItemId + '\'' +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }

    public CartItem(String cartItemId, int quantity, double subtotal) {
        this.cartItemId = cartItemId;
        this.quantity = quantity;
        this.subtotal = subtotal;

    }
    public static class Builder {
        private String cartItemId;
        private int quantity;
        private double subtotal;

        public Builder setCartItemId(String cartItemId) {
            this.cartItemId = cartItemId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setSubtotal(double subtotal) {
            this.subtotal = subtotal;
            return this;
        }
        public Builder copy(CartItem cartItem) {
            this.cartItemId = cartItem.cartItemId;
            this.quantity = cartItem.quantity;
            this.subtotal = cartItem.subtotal;
            return this;
        }
        public CartItem build() {
            return new CartItem(cartItemId, quantity, subtotal);
        }
    }}
