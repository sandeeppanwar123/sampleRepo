package org.mapper.memory.mapper;

import org.mapper.memory.dto.AddQADTO;
import org.mapper.memory.entity.QAEntity;

import java.util.UUID;

public final class QADTOMapper {
    private QADTOMapper() {
    }

    public static QAEntity getQAEntityFromQADTO(AddQADTO addQADTO) {
        QAEntity qaEntity = new QAEntity();
        qaEntity.setQuestion(addQADTO.getQuestion());
        qaEntity.setAnswer(addQADTO.getAnswer());
        qaEntity.setqId(generateQuestionId());
        return qaEntity;
    }

    private static String generateQuestionId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
