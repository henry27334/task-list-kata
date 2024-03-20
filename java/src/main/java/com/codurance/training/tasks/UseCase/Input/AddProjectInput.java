package com.codurance.training.tasks.UseCase.Input;

import com.codurance.training.tasks.Entity.ValueObject.ProjectName;

public class AddProjectInput implements UseCaseInput{

    private ProjectName projectName;

    public ProjectName getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = new ProjectName(projectName);
    }
}
