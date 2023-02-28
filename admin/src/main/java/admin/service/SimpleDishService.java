package admin.service;

import domain.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SimpleDishService implements DishService {

    @Value("${dish-api-url}")
    private String url;

    private final RestTemplate client;

    @Autowired
    public SimpleDishService(RestTemplate client) {
        this.client = client;
    }

    @Override
    public Dish addDish(Dish dish) {
        return client.postForEntity(
                url, dish, Dish.class
        ).getBody();
    }

    @Override
    public List<Dish> findAll() {
        return getList(String.format(
                "%s/getAll", url
        ));
    }

    private List<Dish> getList(String url) {
        List<Dish> body = client.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }

    @Override
    public Optional<Dish> findById(int id) {
        return Optional.ofNullable(client.getForEntity(
                String.format("%s/getById?id=%s", url, id),
                Dish.class
        ).getBody());
    }

    @Override
    public boolean update(int id, Dish dish) {
        return client.exchange(
                String.format("%s?id=%s", url, id),
                HttpMethod.PUT,
                new HttpEntity<>(dish),
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    @Override
    public boolean delete(int id) {
        return client.exchange(
                String.format("%s?id=%s", url, id),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    @PreDestroy
    public void close() throws Exception {

    }
}
