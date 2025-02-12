package com.example.quiz_service.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
public class Quiz {

    @Id
    private Integer id;

    private String title;

    @ElementCollection
    private List<Integer> questionIds;

    public Quiz() {
    }

    public Quiz(Integer id, String title, List<Integer> questions) {
        this.id = id;
        this.title = title;
        this.questionIds = questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getQuestionIds() {
        return this.questionIds;
    }

    public void setQuestionIds(List<Integer> questionIds) {
        this.questionIds = questionIds;
    }
}
