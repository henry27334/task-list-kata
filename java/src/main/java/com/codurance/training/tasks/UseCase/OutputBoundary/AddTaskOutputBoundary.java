package com.codurance.training.tasks.UseCase.OutputBoundary;

public class AddTaskOutputBoundary implements UseCaseOutputBoundary{

    private long taskId;
    private String message;

    public AddTaskOutputBoundary() {}

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
