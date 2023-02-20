package order.service;

import src.main.java.domain.model.Order;
import src.main.java.domain.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import order.repository.OrderRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SimpleOrderService implements OrderService {

    private final OrderRepository orders;

    @Autowired
    public SimpleOrderService(OrderRepository orders) {
        this.orders = orders;
    }

    @Override
    public Order createOrder(Order order) {
        return orders.save(order);
    }

    @Override
    public Optional<Order> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Status checkStatus(int orderId) {
        Optional<Order> order = orders.findById(orderId);
        if (order.isEmpty()) {
            throw new NoSuchElementException("Order with id: " + orderId + " not found");
        }
        return order.get().getStatus();
    }

    @Override
    public void delete(Order order) {
        orders.delete(order);
    }

}
