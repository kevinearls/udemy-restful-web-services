package dev.kearls.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static AtomicInteger userCount = new AtomicInteger(0);

    static {
        users.add(new User(userCount.incrementAndGet(), "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(userCount.incrementAndGet(), "Adam", LocalDate.now().minusYears(25)));
        users.add(new User(userCount.incrementAndGet(), "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save (User user) {
        user.setId(userCount.incrementAndGet());
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        var target =  users.stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
                //.get();

        return target;
    }
}
