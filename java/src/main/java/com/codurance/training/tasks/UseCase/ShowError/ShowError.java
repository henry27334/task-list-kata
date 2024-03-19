package com.codurance.training.tasks.UseCase.ShowError;

import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.Input.ShowErrorInput;
import com.codurance.training.tasks.UseCase.Output.ShowErrorOutput;

public class ShowError implements UseCaseInterface<ShowErrorInput, ShowErrorOutput>{

    public ShowError () {}

    @Override
    public ShowErrorOutput execute(ShowErrorInput input) {
        String message = String.format("I don't know what the command \"%s\" is.%n", input.getMessage());
        ShowErrorOutput showErrorOutput = new ShowErrorOutput();        
        showErrorOutput.setMessage(message);

        return showErrorOutput;
    }
}
