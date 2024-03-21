package com.codurance.training.tasks.UseCase.OutputBoundary;

public class CheckTaskOutputBoundary implements UseCaseOutputBoundary {

    private String message;

    @Override
    public String getOutput() {
        return message;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
