package org.mapper.memory.resources;

import org.mapper.memory.dto.AddQADTO;
import org.mapper.memory.entity.QAEntity;
import org.mapper.memory.service.QAService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/smart")
public class QAResources {

    private QAService qaService;

    public QAResources(QAService qaService) {
        this.qaService = qaService;
    }
//
//    @GetMapping("/{id}")
//    private Mono<QAEntity> getQAById(@PathVariable String id) {
//        return qaService.findQAById(id);
//    }

    @PutMapping
    public Mono<QAEntity> addQuestion(@RequestBody AddQADTO addQADTO) {
        return qaService.createQA(addQADTO);


    }

//
//    @PostMapping("/{remember}")
//    public Mono<QAEntity> increaseRememberCount(@RequestBody(required = false) RememberDTO rememberDTO) {
//        return qaService.rememberQA(rememberDTO);
//
//
//    }


}
