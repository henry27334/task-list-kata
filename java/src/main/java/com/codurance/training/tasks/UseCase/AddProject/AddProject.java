package com.codurance.training.tasks.UseCase.AddProject;

import java.util.List;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.Input.AddProjectInput;
import com.codurance.training.tasks.UseCase.Output.AddProjectOutput;

public class AddProject implements UseCaseInterface<AddProjectInput, AddProjectOutput>{

    @Override
    public AddProjectOutput execute(AddProjectInput input) {

        Project project = new Project(input.getProjectName());

        Projects projects = new Projects();
        List<Project> allProjects = projects.getProjects();
        allProjects.add(project);

        AddProjectOutput addProjectOutput = new AddProjectOutput();

        return addProjectOutput;
    }


}
