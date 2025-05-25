package za.ac.cput.factory;

/*kholiwe Faith Mafenuka
 221686584
 group 3f
 */
import za.ac.cput.domain.Order;
import java.time.LocalDate;

public class OrderFactory {

    // Factory method to create an Order
    public static Order createOrder(String orderId, String orderDate, double totalAmount, String status) {
        if (orderId == null || orderId.isEmpty()) {
            return null;
        }
        if (orderDate == null || orderDate.isEmpty()) {
            return null;
        }
        if (status == null || status.isEmpty()) {
            return null;
        }
        if (totalAmount <= 0) {
            return null;
        }

        return new Order.Builder()
                .setOrderId(orderId)
                .setOrderDate(LocalDate.parse(orderDate))
                .setStatus(status) // Default status
                .setTotalAmount(totalAmount)
                .build();
    }
}
