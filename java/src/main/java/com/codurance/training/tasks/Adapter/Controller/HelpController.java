package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.Presenter.ConsolePresenter;
import com.codurance.training.tasks.UseCase.Help.Help;
import com.codurance.training.tasks.UseCase.Input.HelpInput;
import com.codurance.training.tasks.UseCase.Output.HelpOutput;

public class HelpController implements BaseController {

    private Help help;

    public HelpController(Help help){
        this.help = help;
    }

    @Override
    public ConsolePresenter execute(String command) {
        HelpInput helpInput = new HelpInput();
        HelpOutput helpOutput = help.execute(helpInput);
        ConsolePresenter consolePresenter = new ConsolePresenter(helpOutput.getMessage());
        consolePresenter.setPresentStatus();
        
        return consolePresenter;
    }
}
