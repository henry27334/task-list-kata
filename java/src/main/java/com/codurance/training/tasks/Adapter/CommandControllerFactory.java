package com.codurance.training.tasks.Adapter;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Adapter.Controller.AddAction;
import com.codurance.training.tasks.Adapter.Controller.BaseController;
import com.codurance.training.tasks.Adapter.Controller.CheckController;
import com.codurance.training.tasks.Adapter.Controller.ErrorController;
import com.codurance.training.tasks.Adapter.Controller.HelpController;
import com.codurance.training.tasks.Adapter.Controller.ShowController;
import com.codurance.training.tasks.Adapter.Controller.UncheckController;
import com.codurance.training.tasks.Presenter.ConsolePresenter;
import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;
import com.codurance.training.tasks.UseCase.Help.Help;
import com.codurance.training.tasks.UseCase.ShowError.ShowError;

public class CommandControllerFactory {

    private final Map<String, List<GetTaskImpl>> tasks = new LinkedHashMap<>();;

    public CommandControllerFactory() {}

    public ConsolePresenter execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        BaseController selectedAction;
    
        switch (command) {
            // case "show":
            //     selectedAction = new ShowController();
            //     break;
            // case "add":
            //     selectedAction = new AddAction();
            //     break;
            // case "check":
            //     selectedAction = new CheckController();
            //     break;
            // case "uncheck":
            //     selectedAction = new UncheckController();
            //     break;
            case "help":
                Help help = new Help();
                selectedAction = new HelpController(help);
                break;
            default:
                ShowError showError = new ShowError();
                selectedAction = new ErrorController(showError);
                break;

        }
        
        ConsolePresenter consolePresenter = selectedAction.execute(commandLine);
        return consolePresenter;
    }    
}
