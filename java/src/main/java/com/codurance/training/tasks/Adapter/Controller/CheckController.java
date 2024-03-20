package com.codurance.training.tasks.Adapter.Controller;


import com.codurance.training.tasks.Presenter.ConsolePresenter;
import com.codurance.training.tasks.UseCase.CheckTask.CheckTask;
import com.codurance.training.tasks.UseCase.Input.CheckTaskInput;
import com.codurance.training.tasks.UseCase.Output.CheckTaskOutput;


public class CheckController implements BaseController {

    private CheckTask checkTask;

    public CheckController(CheckTask checkTask) {
        this.checkTask = checkTask;
    }

    @Override
    public ConsolePresenter execute(String command) {
        String[] subcommandRest = command.split(" ", 3);
        String subcommand = subcommandRest[1];

        CheckTaskInput checkTaskInput = new CheckTaskInput();
        checkTaskInput.setId(Integer.parseInt(subcommand));
        CheckTaskOutput checkTaskOutput = checkTask.execute(checkTaskInput);

        ConsolePresenter consolePresenter = new ConsolePresenter(checkTaskOutput.getMessage());
        
        if(consolePresenter.getMessage() != null){
            consolePresenter.setPresentStatus();
        }
        
        return consolePresenter;
    }
    
}
