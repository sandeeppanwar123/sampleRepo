package org.memory.mapper.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    private String userId;
    private int Count;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }
}
