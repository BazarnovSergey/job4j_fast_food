package notification.service;

import domain.model.Notification;
import domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    Notification addNotification(Notification notification);

    List<Notification> findAll();

    Optional<Notification> findById(int id);

    boolean update(int id, Notification notification);

    boolean delete(int id);

    Notification saveOrderInfo(Order order);
}
