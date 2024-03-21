package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.IO.ConsolePresenter;
import com.codurance.training.tasks.UseCase.InputBoundary.ShowProjectInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.ShowProjectOutputBoundary;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.ShowProject;

public class ShowProjectController implements BaseController{
    private ShowProject showProject;

    public ShowProjectController(ShowProject showProject) {
        this.showProject = showProject;
    }

    @Override
    public ConsolePresenter execute(String command) {
        ShowProjectInputBoundary showProjectInput = new ShowProjectInputBoundary();
        ShowProjectOutputBoundary showProjectOutput = showProject.execute(showProjectInput);

        String output = showProjectOutput.getMessage();
        ConsolePresenter consolePresenter = new ConsolePresenter(output);
        
        if (output != null) {
            consolePresenter.setPresentStatus();
        }

        return consolePresenter;
        
    }
    
}
