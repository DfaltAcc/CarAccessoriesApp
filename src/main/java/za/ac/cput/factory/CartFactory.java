package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.util.Helper;

public class CartFactory {


    public static Cart createCart(String cartId, long dateCreated) {
        if (Helper.isNullOrEmpty(cartId) || dateCreated <= 0)
            return null;

        return new Cart.Builder().setCartId(cartId)
                .setDateCreated(dateCreated)
                .build();
    }
}