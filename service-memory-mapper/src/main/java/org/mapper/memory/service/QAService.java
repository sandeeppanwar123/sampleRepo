package org.mapper.memory.service;

import org.mapper.memory.dto.AddQADTO;
import org.mapper.memory.entity.QAEntity;
import org.mapper.memory.entity.UserAndQAMapping;
import org.mapper.memory.mapper.QADTOMapper;
import org.mapper.memory.repository.MappingRepository;
import org.mapper.memory.repository.QARepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class QAService {

    private QARepository qaRepository;
    private MappingRepository mappingRepository;
    private MongoTemplate mongoTemplate;

    public QAService(QARepository qaRepository, MongoTemplate mongoTemplate, MappingRepository mappingRepository) {
        this.qaRepository = qaRepository;
        this.mongoTemplate = mongoTemplate;
        this.mappingRepository = mappingRepository;
    }

    public Mono<QAEntity> createQA(AddQADTO addQADTO) {
        return Mono.just(addQADTO)
                .map(QADTOMapper::getQAEntityFromQADTO)
                .flatMap(qaRepository::save);
    }

    public Mono<QAEntity> getQARandomly() {

        return getRandomNumber()
                .flatMap(t -> qaRepository.findById(t));


    }


    private Mono<Long> getRandomNumber() {
        return qaRepository.count()
                .map(t -> t.intValue())
                .map(x -> 1 + (int) (Math.random() * ((x - 1) + 1)))
                .flatMap(this::fetchMapping)
                .filter(y -> y.getCount() < 10)
                .map(t -> t.getqId())
                .switchIfEmpty(Mono.empty());

    }
//private Mono<UserAndQAMapping> saveMapping(Integer randomNumber)
//{
//    UserAndQAMapping userAndQAMapping = new UserAndQAMapping();
//    userAndQAMapping.setqId(randomNumber.longValue());
//    userAndQAMapping.setUserId("sks");
//   // userAndQAMapping.setCount(0);
//   return mappingRepository.save(userAndQAMapping);
//}

    private Mono<UserAndQAMapping> fetchMapping(Integer integerRndm) {
        return mappingRepository.findById(integerRndm.longValue());
    }

    public UserAndQAMapping updateMapping(Long qId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("qId").is(qId));
        Update update = new Update();
        update.inc("count", 1);
        return mongoTemplate.findAndModify(query, update, UserAndQAMapping.class);
    }
}

