package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.IO.MessagePresenter;
import com.codurance.training.tasks.UseCase.InputBoundary.UncheckTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.UncheckTaskOutputBoundary;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.UncheckTask;

public class UncheckController implements BaseController{

    private UncheckTask uncheckTask;

    public UncheckController(UncheckTask uncheckTask) {
        this.uncheckTask = uncheckTask;
    }

    @Override
    public MessagePresenter execute(String command) {
        String[] subcommandRest = command.split(" ", 3);
        String subcommand = subcommandRest[1];

        UncheckTaskInputBoundary uncheckTaskInput = new UncheckTaskInputBoundary();
        uncheckTaskInput.setId(subcommand);
        UncheckTaskOutputBoundary uncheckTaskOutput = uncheckTask.execute(uncheckTaskInput);

        MessagePresenter consolePresenter = new MessagePresenter(uncheckTaskOutput.getMessage());
        
        if(consolePresenter.getMessage() != null){
            consolePresenter.setPresentStatus();
        }
        
        return consolePresenter;
    }
    

}
