package com.codurance.training.tasks.UseCase.Input;

import com.codurance.training.tasks.Entity.ProjectName;

public class AddTaskInput implements UseCaseInput {
    private long taskId; 
    private ProjectName projectName;
    private String taskDescription;
    private boolean isCheck;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getProjectName() {
        return projectName.value();
    }

    public void setProjectName(ProjectName projectName) {
        this.projectName = projectName;
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
