package order.service;

import domain.model.Order;
import domain.model.Status;

import java.util.Optional;

public interface OrderService {

    Order createOrder(Order order);

    Optional<Order> findById(int id);

    Status checkStatus(int orderId);

    void delete(Order order);

}
