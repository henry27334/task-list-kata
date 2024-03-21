package com.codurance.training.tasks.UseCase.InputBoundary;

public class ShowErrorInputBoundary implements UseCaseInputBoundary {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
