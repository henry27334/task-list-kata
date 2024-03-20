package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.Presenter.ConsolePresenter;
import com.codurance.training.tasks.UseCase.AddProject.AddProject;
import com.codurance.training.tasks.UseCase.Input.AddProjectInput;
import com.codurance.training.tasks.UseCase.Output.AddProjectOutput;

public class AddProjectController implements BaseController {
    private AddProject addProject;

    public AddProjectController(AddProject addProject) {
        this.addProject = addProject;
    }

    @Override
    public ConsolePresenter execute(String command) {

        String[] subcommandRest = command.split(" ", 3);

        AddProjectInput addProjectInput = new AddProjectInput();
        addProjectInput.setProjectName(subcommandRest[2]);
        AddProjectOutput addProjectOutput = addProject.execute(addProjectInput);
        
        ConsolePresenter consolePresenter = new ConsolePresenter(addProjectOutput.getMessage());
        
        return consolePresenter;
    }
    
}
