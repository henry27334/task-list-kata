package com.codurance.training.tasks.UseCase.AddProject;

import java.util.List;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.InputBoundary.AddProjectInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.AddProjectOutputBoundary;

public class AddProject implements UseCaseInterface<AddProjectInputBoundary, AddProjectOutputBoundary>{

    @Override
    public AddProjectOutputBoundary execute(AddProjectInputBoundary input) {

        Project project = new Project(input.getProjectName());
        Projects projects = Projects.getProjectList();
        List<Project> allProjects = projects.getProjects();
        allProjects.add(project);

        AddProjectOutputBoundary addProjectOutput = new AddProjectOutputBoundary();

        return addProjectOutput;
    }


}
