package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.IO.MessagePresenter;
import com.codurance.training.tasks.UseCase.InputBoundary.AddProjectInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.AddProjectOutputBoundary;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.AddProject;

public class AddProjectController implements BaseController {
    private AddProject addProject;

    public AddProjectController(AddProject addProject) {
        this.addProject = addProject;
    }

    @Override
    public MessagePresenter execute(String command) {

        String[] subcommandRest = command.split(" ", 3);

        AddProjectInputBoundary addProjectInput = new AddProjectInputBoundary();
        addProjectInput.setProjectName(subcommandRest[2]);
        AddProjectOutputBoundary addProjectOutput = addProject.execute(addProjectInput);
        
        MessagePresenter consolePresenter = new MessagePresenter(addProjectOutput.getMessage());
        
        return consolePresenter;
    }
    
}
