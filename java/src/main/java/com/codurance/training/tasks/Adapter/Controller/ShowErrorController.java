package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.IO.MessagePresenter;
import com.codurance.training.tasks.UseCase.InputBoundary.ShowErrorInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.ShowErrorOutputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.UseCaseOutputBoundary;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.UseCaseInterface;

public class ShowErrorController implements BaseController {
    private UseCaseInterface<ShowErrorInputBoundary, ShowErrorOutputBoundary> showError;
    
    public ShowErrorController(UseCaseInterface<ShowErrorInputBoundary, ShowErrorOutputBoundary> showError){
        this.showError = showError;
    }

    @Override
    public MessagePresenter execute(String command) {
        ShowErrorInputBoundary showErrorInput = new ShowErrorInputBoundary();
        showErrorInput.setMessage(command);
        UseCaseOutputBoundary showErrorOutput = showError.execute(showErrorInput);

        MessagePresenter consolePresenter = new MessagePresenter(showErrorOutput.getOutput());
        consolePresenter.setPresentStatus();

        return consolePresenter;
    }
    
}
