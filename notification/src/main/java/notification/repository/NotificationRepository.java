package notification.repository;

import domain.model.Notification;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {

    @NonNull
    List<Notification> findAll();

}
