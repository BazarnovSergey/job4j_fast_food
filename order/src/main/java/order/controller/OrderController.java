package order.controller;

import src.main.java.domain.model.Order;
import src.main.java.domain.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import order.service.OrderService;

import java.util.Optional;

/**
 * контроллер для работы с заказами
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return new ResponseEntity<Order>(
                this.orderService.createOrder(order),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable int id) {
        Optional<Order> order = orderService.findById(id);
        return new ResponseEntity<Order>(
                order.orElse(new Order()),
                order.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<Status> checkStatus(@PathVariable int id) {
        return new ResponseEntity<Status>(
                orderService.checkStatus(id),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Order order = new Order();
        var deletedOrder = this.orderService.findById(id);
        if (deletedOrder.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Order is not found. Please, check requisites.");
        }
        order.setId(id);
        this.orderService.delete(order);
        return ResponseEntity.ok().build();
    }

}
