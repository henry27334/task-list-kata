package com.codurance.training.tasks.UseCase.InputBoundary;

import com.codurance.training.tasks.Entity.ValueObject.TaskListId;

public class ShowProjectInputBoundary implements UseCaseInputBoundary {
    private TaskListId taskListId;

    public TaskListId getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(String taskListId) {
        this.taskListId = TaskListId.of(taskListId);
    }
}
