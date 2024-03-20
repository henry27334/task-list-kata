package com.codurance.training.tasks.UseCase.ShowHelp;

import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.Input.ShowHelpInput;
import com.codurance.training.tasks.UseCase.Output.ShowHelpOutput;

public class ShowHelp implements UseCaseInterface<ShowHelpInput, ShowHelpOutput> {

    @Override
    public ShowHelpOutput execute(ShowHelpInput input) {
        String message = "Commands:" + "\n" + 
                         "  show" + "\n" +
                         "  add project <project name>" + "\n" +
                         "  add task <project name> <task description>" + "\n" +
                         "  check <task ID>" + "\n" +
                         "  uncheck <task ID>" + "\n";

        ShowHelpOutput helpOutput = new ShowHelpOutput();
        helpOutput.setMessage(message);
        return helpOutput;
    }
    
}
