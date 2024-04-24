package com.codurance.training.tasks.UseCase.InputBoundary;

import com.codurance.training.tasks.Entity.ValueObject.ProjectName;
import com.codurance.training.tasks.Entity.ValueObject.TaskListId;

public class AddProjectInputBoundary implements UseCaseInputBoundary{
    private TaskListId taskListId;
    private ProjectName projectName;

    public TaskListId getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(String taskListId) {
        this.taskListId = TaskListId.of(taskListId);
    }

    public ProjectName getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = ProjectName.of(projectName);
    }

}
