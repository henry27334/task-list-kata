package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.Presenter.ConsolePresenter;
import com.codurance.training.tasks.UseCase.InputBoundary.UncheckTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.UncheckTaskOutputBoundary;
import com.codurance.training.tasks.UseCase.UncheckTask.UncheckTask;

public class UncheckController implements BaseController{

    private UncheckTask uncheckTask;

    public UncheckController(UncheckTask uncheckTask) {
        this.uncheckTask = uncheckTask;
    }

    @Override
    public ConsolePresenter execute(String command) {
        String[] subcommandRest = command.split(" ", 3);
        String subcommand = subcommandRest[1];

        UncheckTaskInputBoundary uncheckTaskInput = new UncheckTaskInputBoundary();
        uncheckTaskInput.setId(Integer.parseInt(subcommand));
        UncheckTaskOutputBoundary uncheckTaskOutput = uncheckTask.execute(uncheckTaskInput);

        ConsolePresenter consolePresenter = new ConsolePresenter(uncheckTaskOutput.getMessage());
        
        if(consolePresenter.getMessage() != null){
            consolePresenter.setPresentStatus();
        }
        
        return consolePresenter;
    }
    

}
