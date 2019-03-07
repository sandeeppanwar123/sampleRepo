package org.memory.mapper.repository;

import org.memory.mapper.entity.QAEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface QARepository extends ReactiveCrudRepository<QAEntity, String> {

}
