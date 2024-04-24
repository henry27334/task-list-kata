package com.codurance.training.tasks.UseCase.InputBoundary;

import com.codurance.training.tasks.Entity.ValueObject.ProjectName;
import com.codurance.training.tasks.Entity.ValueObject.TaskListId;

public class AddTaskInputBoundary implements UseCaseInputBoundary {

    private TaskListId taskListId;
    private long taskId; 
    private ProjectName projectName;
    private String taskDescription;
    private boolean isCheck;

    public TaskListId getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(String taskListId) {
        this.taskListId = TaskListId.of(taskListId);
    }
    
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public ProjectName getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = new ProjectName(projectName);
    }

    public String getDescription() {
        return taskDescription;
    }

    public void setDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean getCheck() {
        return isCheck;
    }

    public void setCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }
}
