package com.codurance.training.tasks.UseCase.ShowError;

import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.InputBoundary.ShowErrorInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.ShowErrorOutputBoundary;

public class ShowError implements UseCaseInterface<ShowErrorInputBoundary, ShowErrorOutputBoundary>{

    public ShowError () {}

    @Override
    public ShowErrorOutputBoundary execute(ShowErrorInputBoundary input) {
        String message = String.format("I don't know what the command \"%s\" is.%n", input.getMessage());
        ShowErrorOutputBoundary showErrorOutput = new ShowErrorOutputBoundary();        
        showErrorOutput.setMessage(message);

        return showErrorOutput;
    }
}
