package com.codurance.training.tasks.UseCase.InputBoundary;

public class UncheckTaskInputBoundary implements UseCaseInputBoundary {
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }   
}
