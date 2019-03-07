package org.memory.mapper.mapper;

import org.memory.mapper.dto.dto;
import org.memory.mapper.entity.QAEntity;
import org.memory.mapper.entity.User;

public final class QADTOMapper {

    private QADTOMapper() {
    }

    public static QAEntity getQAEntityFromQADTO(dto.QADTO qadto) {
        QAEntity qaEntity = new QAEntity();
        qaEntity.setId(qadto.getId());
        qaEntity.setQuestion(qadto.getQuestion());
        qaEntity.setAnswer(qadto.getAnswer());

        User user = new User();
        user.setUserId(qadto.getUser().getUserId());
        user.setCount(0);
        qaEntity.setUser(user);
        return qaEntity;


    }
}
