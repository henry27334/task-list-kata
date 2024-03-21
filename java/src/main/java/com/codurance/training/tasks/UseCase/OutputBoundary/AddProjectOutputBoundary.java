package com.codurance.training.tasks.UseCase.OutputBoundary;

public class AddProjectOutputBoundary implements UseCaseOutputBoundary{
    private String message;

    public AddProjectOutputBoundary() {}

    @Override
    public String getOutput() {
        return getMessage();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
