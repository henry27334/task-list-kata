package com.codurance.training.tasks.UseCase.InputBoundary;


public class UncheckTaskInputBoundary implements UseCaseInputBoundary {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }   
}
