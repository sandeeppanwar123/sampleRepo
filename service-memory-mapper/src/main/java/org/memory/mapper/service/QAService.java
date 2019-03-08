package org.memory.mapper.service;

import org.memory.mapper.dto.RememberDTO;
import org.memory.mapper.dto.dto;
import org.memory.mapper.entity.QAEntity;
import org.memory.mapper.entity.User;
import org.memory.mapper.mapper.QADTOMapper;
import org.memory.mapper.repository.QARepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class QAService {

    private QARepository qaRepository;
    private MongoTemplate mongoTemplate;

    public QAService(QARepository qaRepository, MongoTemplate mongoTemplate) {
        this.qaRepository = qaRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Mono<QAEntity> createQA(@RequestBody(required = false) dto.QADTO qadto) {
        return Mono.just(qadto)
                .map(QADTOMapper::getQAEntityFromQADTO)
                .flatMap(qaRepository::save);
    }

    public Mono<QAEntity> findQAById(String id) {


        return qaRepository.findById(id)
                .filter(t -> this.doYouRememberThis(t, "sks"))
                .switchIfEmpty(Mono.empty());

    }

    public Mono<QAEntity> rememberQA(RememberDTO rememberDTO) {

        return qaRepository.findById(rememberDTO.getId())
                .map(t -> this.updateCounter(t, rememberDTO))
                .flatMap(qaRepository::save);
    }

    private QAEntity updateCounter(QAEntity qaEntity, RememberDTO rememberDTO) {

        List<User> userList = new ArrayList<>();
        for (User user : qaEntity.getUserList()) {
            if (user.getUserId().equals(rememberDTO.getUserId()) && user.getCount() < 10) {
                user.setCount(user.getCount() + 1);
            }
            userList.add(user);
        }
        qaEntity.setUserList(userList);
        return qaEntity;

    }

    private Boolean doYouRememberThis(QAEntity qaEntity, String currentUser) {
        for (User user : qaEntity.getUserList()) {
            if (user.getUserId().equals(currentUser) && user.getCount() < 10) {
                return true;
            }

        }
        return false;
    }
}

