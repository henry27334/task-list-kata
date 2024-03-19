package com.codurance.training.tasks.UseCase.Input;

import com.codurance.training.tasks.Entity.ProjectName;

public class AddProjectInput {

    private ProjectName projectName;

    public AddProjectInput() {}

    public ProjectName getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = new ProjectName(projectName);
    }
}
