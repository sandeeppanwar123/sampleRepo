package org.memory.mapper.service;

import org.memory.mapper.dto.dto;
import org.memory.mapper.entity.QAEntity;
import org.memory.mapper.mapper.QADTOMapper;
import org.memory.mapper.repository.QARepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@Service
public class QAService {

    private QARepository qaRepository;

    public QAService(QARepository qaRepository) {
        this.qaRepository = qaRepository;
    }

    public Mono<QAEntity> createQA(@RequestBody(required = false) dto.QADTO qadto) {
        return Mono.just(qadto)
                .map(QADTOMapper::getQAEntityFromQADTO)
                .flatMap(qaRepository::save);
    }

    public Mono<QAEntity> findQAById(String id) {
        return qaRepository.findById(id);
    }
}
