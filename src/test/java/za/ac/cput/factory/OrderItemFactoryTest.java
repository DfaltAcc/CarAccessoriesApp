package za.ac.cput.factory;
/*kholiwe Faith Mafenuka
 221686584
 group 3f
 */
import junit.framework.TestCase;
import za.ac.cput.domain.OrderItem;

public class OrderItemFactoryTest extends TestCase {

    public void testCreateOrderItem() {

        OrderItem orderItem = OrderItemFactory.createOrderItem("orderId", 2, 250.0);

        assertNotNull(orderItem);
        assertEquals("orderId", orderItem.getOrderItemId());
        assertEquals(2, orderItem.getQuantity());
        assertEquals(250.0, orderItem.getPriceAtPurchase());
    }
    public void testCreateOrderItemWithNullId() {
        OrderItem orderItem = OrderItemFactory.createOrderItem(null, 2, 250.00);
        assertNull(orderItem);
    }
    public void testCreateOrderItemWithEmptyId() {
        OrderItem orderItem = OrderItemFactory.createOrderItem("", 2, 250.00);
        assertNull(orderItem);
    }
    public void testCreateOrderItemWithNegativeQuantity() {
        OrderItem orderItem = OrderItemFactory.createOrderItem("orderId", -2, 250.00);
        assertNull(orderItem);
    }
    public void testCreateOrderItemWithNegativePrice() {
        OrderItem orderItem = OrderItemFactory.createOrderItem("orderId", 2, -250.00);
        assertNull(orderItem);
    }
}