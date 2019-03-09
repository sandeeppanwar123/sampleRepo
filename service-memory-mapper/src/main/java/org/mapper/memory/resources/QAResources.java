package org.mapper.memory.resources;

import org.mapper.memory.dto.AddQADTO;
import org.mapper.memory.dto.MappingDTO;
import org.mapper.memory.entity.QAEntity;
import org.mapper.memory.entity.UserAndQAMapping;
import org.mapper.memory.service.QAService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/smart")
public class QAResources {

    private QAService qaService;

    public QAResources(QAService qaService) {
        this.qaService = qaService;
    }

    @GetMapping("/{random}")
    private Mono<QAEntity> getQARandomly() {
        return qaService.getQARandomly();
    }

    @PutMapping
    public Mono<QAEntity> addQuestion(@RequestBody AddQADTO addQADTO) {
        return qaService.createQA(addQADTO);


    }

    @PostMapping("/{remember}")
    public UserAndQAMapping remember(@RequestBody MappingDTO mappingDTO) {
        return qaService.updateMapping(Long.parseUnsignedLong(mappingDTO.getqId()));
    }


}
