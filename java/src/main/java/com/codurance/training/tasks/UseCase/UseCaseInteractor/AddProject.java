package com.codurance.training.tasks.UseCase.UseCaseInteractor;

import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.UseCase.InputBoundary.AddProjectInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.AddProjectOutputBoundary;

public class AddProject implements UseCaseInterface<AddProjectInputBoundary, AddProjectOutputBoundary>{

    @Override
    public AddProjectOutputBoundary execute(AddProjectInputBoundary input) {

        TaskList projects = TaskList.getTaskList();
        projects.addProject(input.getProjectName());

        AddProjectOutputBoundary addProjectOutput = new AddProjectOutputBoundary();

        return addProjectOutput;
    }


}
