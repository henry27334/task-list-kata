package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.Presenter.ConsolePresenter;
import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.Input.ShowErrorInput;
import com.codurance.training.tasks.UseCase.Output.ShowErrorOutput;
import com.codurance.training.tasks.UseCase.Output.UseCaseOutput;

public class ShowErrorController implements BaseController {
    private UseCaseInterface<ShowErrorInput, ShowErrorOutput> showError;
    
    public ShowErrorController(UseCaseInterface<ShowErrorInput, ShowErrorOutput> showError){
        this.showError = showError;
    }

    @Override
    public ConsolePresenter execute(String command) {
        ShowErrorInput showErrorInput = new ShowErrorInput();
        showErrorInput.setMessage(command);
        UseCaseOutput showErrorOutput = showError.execute(showErrorInput);

        ConsolePresenter consolePresenter = new ConsolePresenter(showErrorOutput.getOutput());
        consolePresenter.setPresentStatus();

        return consolePresenter;
    }
    
}
