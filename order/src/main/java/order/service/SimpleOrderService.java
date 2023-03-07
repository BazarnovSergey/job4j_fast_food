package order.service;

import domain.model.Order;
import domain.model.Status;
import order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SimpleOrderService implements OrderService {

    private final OrderRepository orders;

    private final KafkaTemplate<Integer, Order> kafkaTemplate;

    @Autowired
    public SimpleOrderService(OrderRepository orders, KafkaTemplate<Integer, Order> kafkaTemplate) {
        this.orders = orders;
        this.kafkaTemplate = kafkaTemplate;
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

    @Override
    public void sendOrder(Order order) {
        kafkaTemplate.send("order", order);
    }

}
