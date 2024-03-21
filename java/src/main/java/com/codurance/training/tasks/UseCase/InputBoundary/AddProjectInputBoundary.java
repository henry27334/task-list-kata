package com.codurance.training.tasks.UseCase.InputBoundary;

import com.codurance.training.tasks.Entity.ValueObject.ProjectName;

public class AddProjectInputBoundary implements UseCaseInputBoundary{

    private ProjectName projectName;

    public ProjectName getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = new ProjectName(projectName);
    }
}
