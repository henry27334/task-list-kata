package com.codurance.training.tasks.UseCase.Output;

public class ShowErrorOutput implements UseCaseOutput {

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
