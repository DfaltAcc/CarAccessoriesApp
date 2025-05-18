package za.ac.cput.factory;
/*kholiwe Faith Mafenuka
 221686584
 group 3f
 */
import junit.framework.TestCase;
import za.ac.cput.domain.Order;
import java.time.LocalDate;

public class OrderFactoryTest extends TestCase {

    public void testCreateOrder() {

        Order order = OrderFactory.createOrder("orderId", "2004-03-06", 123.00, "pending");

        assertNotNull(order);
        assertEquals("orderId", order.getOrderId());
        assertNotNull(order.getOrderDate());
        assertEquals(123.00, order.getTotalAmount());
        assertEquals("pending", order.getStatus());

    }
    public void testCreateOrderWithNullId() {
        Order order = OrderFactory.createOrder(null, "customerId", 123.00, "Pending");
        assertNull(order);
    }
    public void testCreateOrderWithEmptyId() {
        Order order = OrderFactory.createOrder("", "customerId", 123.00, "Pending");
        assertNull(order);
    }
    public void testCreateOrderWithNegativeAmount() {
        Order order = OrderFactory.createOrder("orderId", "customerId", -123.00, "Pending");
        assertNull(order);
    }
}