package com.example.quiz_service.model;


public class QuizDto {

    private int quizId;
    private String categoryName;
    private  int numQuestions;
    private String title;

    public QuizDto() {
    }

    public QuizDto(String categoryName, int numQuestions, String title,int quizId) {
        this.categoryName = categoryName;
        this.numQuestions = numQuestions;
        this.title = title;
        this.quizId=quizId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }
}
