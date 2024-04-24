package com.codurance.training.tasks.UseCase.InputBoundary;

import com.codurance.training.tasks.Entity.ValueObject.TaskListId;

public class CheckTaskInputBoundary implements UseCaseInputBoundary {
    private TaskListId taskListId;
    private String id;

    public TaskListId getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(String taskListId) {
        this.taskListId = TaskListId.of(taskListId);
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
