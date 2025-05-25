package za.ac.cput.factory;

/*kholiwe Faith Mafenuka
 221686584
 group 3f
 */

import za.ac.cput.domain.OrderItem;

public class OrderItemFactory {

    // Factory method to create an OrderItem
    public static OrderItem createOrderItem(String orderItemId, int quantity, double priceAtPurchase) {

        if (orderItemId == null || orderItemId.isEmpty()) {
            return null;
        }
        if (quantity <= 0) {
            return null;
        }
        if (priceAtPurchase <= 0) {
            return null;
        }

        return new OrderItem.Builder()
                .setOrderItemId(orderItemId)
                .setQuantity(quantity)
                .setPriceAtPurchase(priceAtPurchase)
                .build();
    }
}
