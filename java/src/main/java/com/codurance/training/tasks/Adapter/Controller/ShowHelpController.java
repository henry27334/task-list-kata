package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.IO.MessagePresenter;
import com.codurance.training.tasks.UseCase.InputBoundary.ShowHelpInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.ShowHelpOutputBoundary;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.ShowHelp;

public class ShowHelpController implements BaseController {

    private ShowHelp help;

    public ShowHelpController(ShowHelp help){
        this.help = help;
    }

    @Override
    public MessagePresenter execute(String command) {
        ShowHelpInputBoundary helpInput = new ShowHelpInputBoundary();
        ShowHelpOutputBoundary helpOutput = help.execute(helpInput);
        MessagePresenter consolePresenter = new MessagePresenter(helpOutput.getMessage());
        consolePresenter.setPresentStatus();
        
        return consolePresenter;
    }
}
