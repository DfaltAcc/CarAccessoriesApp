package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;

public interface OrderRepository extends JpaRepository<Order, String> {

    static OrderRepository getRepository() {

        return null;
    }
}
