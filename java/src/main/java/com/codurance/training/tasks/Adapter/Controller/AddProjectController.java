package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.Presenter.ConsolePresenter;
import com.codurance.training.tasks.UseCase.AddProject.AddProject;
import com.codurance.training.tasks.UseCase.InputBoundary.AddProjectInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.AddProjectOutputBoundary;

public class AddProjectController implements BaseController {
    private AddProject addProject;

    public AddProjectController(AddProject addProject) {
        this.addProject = addProject;
    }

    @Override
    public ConsolePresenter execute(String command) {

        String[] subcommandRest = command.split(" ", 3);

        AddProjectInputBoundary addProjectInput = new AddProjectInputBoundary();
        addProjectInput.setProjectName(subcommandRest[2]);
        AddProjectOutputBoundary addProjectOutput = addProject.execute(addProjectInput);
        
        ConsolePresenter consolePresenter = new ConsolePresenter(addProjectOutput.getMessage());
        
        return consolePresenter;
    }
    
}
