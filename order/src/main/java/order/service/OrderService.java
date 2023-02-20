package order.service;

import src.main.java.domain.model.Order;
import src.main.java.domain.model.Status;

import java.util.Optional;

public interface OrderService {

    Order createOrder(Order order);

    Optional<Order> findById(int id);

    Status checkStatus(int orderId);

    void delete(Order order);

}
