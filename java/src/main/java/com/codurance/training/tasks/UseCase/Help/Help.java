package com.codurance.training.tasks.UseCase.Help;

import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.Input.HelpInput;
import com.codurance.training.tasks.UseCase.Output.HelpOutput;

public class Help implements UseCaseInterface<HelpInput, HelpOutput> {

    @Override
    public HelpOutput execute(HelpInput input) {
        String message = "Commands:" + "\n" + 
                         "  show" + "\n" +
                         "  add project <project name>" +
                         "  add task <project name> <task description>" + "\n" +
                         "  check <task ID>" + "\n" +
                         "  uncheck <task ID>" + "\n";

        HelpOutput helpOutput = new HelpOutput();
        helpOutput.setMessage(message);
        return helpOutput;
    }
    
}
