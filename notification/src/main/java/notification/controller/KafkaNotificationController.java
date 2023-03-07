package notification.controller;

import domain.model.Notification;
import domain.model.Order;
import notification.service.NotificationService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaNotificationController {

    private final NotificationService notificationService;

    @Autowired
    public KafkaNotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = {"order"})
    public void onApiCall(ConsumerRecord<Integer, Order> input) {
        Order order = input.value();
        Notification notification = notificationService.saveOrderInfo(order);
        notificationService.addNotification(notification);
    }

}
