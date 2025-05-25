package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    private static Cart cart = CartFactory.createCart("CART123", 1234567890L);
    @Test
    void createCart() {
        assertNotNull(cart);
        System.out.println("Cart created: " + cart);
    }
}