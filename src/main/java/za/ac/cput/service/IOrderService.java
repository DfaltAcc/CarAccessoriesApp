package za.ac.cput.service;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;

import java.util.List;

public interface IOrderService extends IService<Order, String>{

    List<Order> getAll();
}
