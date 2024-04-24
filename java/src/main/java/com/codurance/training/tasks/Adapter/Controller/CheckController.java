package com.codurance.training.tasks.Adapter.Controller;


import com.codurance.training.tasks.IO.MessagePresenter;
import com.codurance.training.tasks.UseCase.InputBoundary.CheckTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.CheckTaskOutputBoundary;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.CheckTask;


public class CheckController implements BaseController {

    private CheckTask checkTask;

    public CheckController(CheckTask checkTask) {
        this.checkTask = checkTask;
    }

    @Override
    public MessagePresenter execute(String command) {
        String[] subcommandRest = command.split(" ", 3);
        String subcommand = subcommandRest[1];

        CheckTaskInputBoundary checkTaskInput = new CheckTaskInputBoundary();
        checkTaskInput.setId(subcommand);
        checkTaskInput.setTaskListId("001");
        CheckTaskOutputBoundary checkTaskOutput = checkTask.execute(checkTaskInput);

        MessagePresenter consolePresenter = new MessagePresenter(checkTaskOutput.getMessage());
        
        if(consolePresenter.getMessage() != null){
            consolePresenter.setPresentStatus();
        }
        
        return consolePresenter;
    }
    
}
