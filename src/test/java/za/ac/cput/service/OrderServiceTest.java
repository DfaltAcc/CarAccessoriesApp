package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.OrderRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

    public class OrderServiceTest {

        private OrderRepository orderRepository;
        private OrderService orderService;

        private Order order;

        @BeforeEach
        void setUp() {
            orderRepository = mock(OrderRepository.class);
            orderService = new OrderService(orderRepository);

            order = new Order.Builder()
                    .setOrderId("ORD123")
                    .setOrderDate(LocalDate.now())
                    .setTotalAmount(1200.00)
                    .setStatus("Processing")
                    .build();
        }

        @Test
        void testCreate() {
            when(orderRepository.save(order)).thenReturn(order);
            Order created = orderService.create(order);
            assertNotNull(created);
            assertEquals("ORD123", created.getOrderId());
        }

        @Test
        void testRead() {
            when(orderRepository.findById("ORD123")).thenReturn(Optional.of(order));
            Order found = orderService.read("ORD123");
            assertNotNull(found);
            assertEquals("ORD123", found.getOrderId());
        }

        @Test
        void testUpdate() {
            when(orderRepository.save(order)).thenReturn(order);
            Order updated = orderService.update(order);
            assertEquals(1200.00, updated.getTotalAmount());
        }

        @Test
        void testDelete() {
            doNothing().when(orderRepository).deleteById("ORD123");
            boolean deleted = orderService.delete("ORD123");
            assertTrue(deleted);
        }

        @Test
        void testGetAll() {
            when(orderRepository.findAll()).thenReturn(Arrays.asList(order));
            assertFalse(orderService.getAll().isEmpty());
        }
    }



