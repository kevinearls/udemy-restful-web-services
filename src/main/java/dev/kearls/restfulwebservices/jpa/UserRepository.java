package dev.kearls.restfulwebservices.jpa;

import dev.kearls.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
