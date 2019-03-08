package org.memory.mapper.dto;

import org.memory.mapper.entity.User;

import java.util.List;

public class dto {
    public static class QADTO {
        private String id;
        private String question;
        private String answer;
        private List<User> userList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public List<User> getUserList() {
            return userList;
        }

        public void setUserList(List<User> userList) {
            this.userList = userList;
        }
    }
}
