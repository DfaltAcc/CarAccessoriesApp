package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderItemFactory;
import za.ac.cput.repository.OrderItemRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderItemServiceTest {

    @Mock
    private OrderItemRepository orderItemRepository;
    private IOrderItemService service;
    private OrderItem orderItem;

    @BeforeEach
    void setUp() {
        service = new OrderItemService(orderItemRepository);
        this.orderItem = OrderItemFactory.createOrderItem("item-3", 4, 15.0);
        service.create(orderItem);
    }

    @Test
    void create() {
        OrderItem item = OrderItemFactory.createOrderItem("item-4", 2, 10.0);
        OrderItem saved = service.create(item);
        assertNotNull(saved);
        System.out.println("Created: " + saved);
    }

    @Test
    void read() {
        OrderItem read = service.read(orderItem.getOrderItemId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        OrderItem newOrderItem = new OrderItem.Builder()
                .copy(orderItem)
                .setQuantity(16)
                .build();
        OrderItem updated = service.update(newOrderItem);
        assertNotNull(updated);
        assertEquals(16, updated.getQuantity());
        System.out.println("Updated: " + updated);
    }

    @Test
    void testGetAll() {
        List<OrderItem> allItems = service.getAll();
        assertFalse(allItems.isEmpty());
        System.out.println("All items: " + allItems);
    }
}



