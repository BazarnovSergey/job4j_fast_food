package notification.service;

import domain.model.Notification;
import domain.model.Order;
import notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimpleNotificationService implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public SimpleNotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification addNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> findById(int id) {
        return notificationRepository.findById(id);
    }

    @Override
    public boolean update(int id, Notification notification) {
        boolean rsl = false;
        Optional<Notification> optionalDish = notificationRepository.findById(id);
        if (optionalDish.isPresent()) {
            notification.setId(id);
            notificationRepository.save(notification);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        notificationRepository.deleteById(id);
        return true;
    }

    @Override
    public Notification saveOrderInfo(Order order) {
        Notification notification = new Notification();
        notification.setText(order.toString());
        return notification;
    }

}
