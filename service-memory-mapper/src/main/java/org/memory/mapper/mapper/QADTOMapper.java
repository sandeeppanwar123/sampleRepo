package org.memory.mapper.mapper;

import org.memory.mapper.dto.dto;
import org.memory.mapper.entity.QAEntity;
import org.memory.mapper.entity.User;

import java.util.ArrayList;
import java.util.List;

public final class QADTOMapper {

    private QADTOMapper() {
    }

    public static QAEntity getQAEntityFromQADTO(dto.QADTO qadto) {
        QAEntity qaEntity = new QAEntity();
        qaEntity.setId(qadto.getId());
        qaEntity.setQuestion(qadto.getQuestion());
        qaEntity.setAnswer(qadto.getAnswer());
        List<User> userList = new ArrayList<User>();
        for (User user : qadto.getUserList()) {
            User user1 = new User();
            user1.setUserId(user.getUserId());
            user1.setCount(0);
            user1.setStatus(true);
            userList.add(user1);

        }
        qaEntity.setUserList(userList);
        return qaEntity;


    }
}
