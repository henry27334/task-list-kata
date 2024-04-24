package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.Entity.ValueObject.TaskListId;
import com.codurance.training.tasks.IO.MessagePresenter;
import com.codurance.training.tasks.UseCase.InputBoundary.ShowProjectInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.ShowProjectOutputBoundary;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.ShowProject;

public class ShowProjectController implements BaseController{
    private ShowProject showProject;

    public ShowProjectController(ShowProject showProject) {
        this.showProject = showProject;
    }

    @Override
    public MessagePresenter execute(String command) {
        ShowProjectInputBoundary showProjectInput = new ShowProjectInputBoundary();
        showProjectInput.setTaskListId("001");
        
        ShowProjectOutputBoundary showProjectOutput = showProject.execute(showProjectInput);

        String output = showProjectOutput.getMessage();
        MessagePresenter consolePresenter = new MessagePresenter(output);
        
        if (output != null) {
            consolePresenter.setPresentStatus();
        }

        return consolePresenter;
        
    }
    
}
