package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.Presenter.ConsolePresenter;
import com.codurance.training.tasks.UseCase.Input.ShowHelpInput;
import com.codurance.training.tasks.UseCase.Output.ShowHelpOutput;
import com.codurance.training.tasks.UseCase.ShowHelp.ShowHelp;

public class ShowHelpController implements BaseController {

    private ShowHelp help;

    public ShowHelpController(ShowHelp help){
        this.help = help;
    }

    @Override
    public ConsolePresenter execute(String command) {
        ShowHelpInput helpInput = new ShowHelpInput();
        ShowHelpOutput helpOutput = help.execute(helpInput);
        ConsolePresenter consolePresenter = new ConsolePresenter(helpOutput.getMessage());
        consolePresenter.setPresentStatus();
        
        return consolePresenter;
    }
}
