package com.codurance.training.tasks.UseCase.Input;

public class ShowErrorInput implements UseCaseInput {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
