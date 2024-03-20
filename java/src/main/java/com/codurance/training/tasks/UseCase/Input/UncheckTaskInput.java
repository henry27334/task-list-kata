package com.codurance.training.tasks.UseCase.Input;

public class UncheckTaskInput implements UseCaseInput {
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }   
}
