package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CartItem;

import static org.junit.jupiter.api.Assertions.*;

class CartItemFactoryTest {
    private static CartItem cartItem = CartItemFactory.createCartItem("ITEM123", 2, 19.99);

    @Test
    void createCartItem() {
        assertNotNull(cartItem);
        System.out.println("CartItem created: " + cartItem);
    }
}