package com.codurance.training.tasks.UseCase.UseCaseInteractor;

import com.codurance.training.tasks.UseCase.InputBoundary.ShowHelpInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.ShowHelpOutputBoundary;

public class ShowHelp implements UseCaseInterface<ShowHelpInputBoundary, ShowHelpOutputBoundary> {

    @Override
    public ShowHelpOutputBoundary execute(ShowHelpInputBoundary input) {
        String message = "Commands:" + "\n" + 
                         "  show" + "\n" +
                         "  add project <project name>" + "\n" +
                         "  add task <project name> <task description>" + "\n" +
                         "  check <task ID>" + "\n" +
                         "  uncheck <task ID>" + "\n";

        ShowHelpOutputBoundary helpOutput = new ShowHelpOutputBoundary();
        helpOutput.setMessage(message);
        return helpOutput;
    }
    
}
