package org.memory.mapper.resources;

import org.memory.mapper.dto.dto;
import org.memory.mapper.entity.QAEntity;
import org.memory.mapper.service.QAService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/smart")
public class smartResources {

    private QAService qaService;

    public smartResources(QAService qaService) {
        this.qaService = qaService;
    }

    @GetMapping("/{id}")
    private Mono<QAEntity> getQAById(@PathVariable String id) {
        return qaService.findQAById(id);
    }

    @PutMapping
    public Mono<QAEntity> addQuestion(@RequestBody(required = false) dto.QADTO qaDTO) {
        return qaService.createQA(qaDTO);


    }


}
