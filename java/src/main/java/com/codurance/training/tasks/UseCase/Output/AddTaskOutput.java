package com.codurance.training.tasks.UseCase.Output;

public class AddTaskOutput implements UseCaseOutput{

    private long taskId;
    private String message;

    public AddTaskOutput() {}

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
    
    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long projectId) {
        this.taskId = projectId;
    }
}
