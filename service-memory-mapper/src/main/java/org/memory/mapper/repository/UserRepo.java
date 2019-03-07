package org.memory.mapper.repository;

import org.memory.mapper.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepo extends ReactiveCrudRepository<User, String> {
}
