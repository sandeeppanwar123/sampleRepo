package org.mapper.memory.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserAndQAMapping {

    private String userId;
    private String qId;
    private int count;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
