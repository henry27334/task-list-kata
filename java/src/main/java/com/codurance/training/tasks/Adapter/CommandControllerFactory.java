package com.codurance.training.tasks.Adapter;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Adapter.Controller.AddAction;
import com.codurance.training.tasks.Adapter.Controller.AddProjectController;
import com.codurance.training.tasks.Adapter.Controller.AddTaskController;
import com.codurance.training.tasks.Adapter.Controller.BaseController;
import com.codurance.training.tasks.Adapter.Controller.CheckController;
import com.codurance.training.tasks.Adapter.Controller.ErrorController;
import com.codurance.training.tasks.Adapter.Controller.ShowHelpController;
import com.codurance.training.tasks.Adapter.Controller.ShowProjectController;
import com.codurance.training.tasks.Adapter.Controller.ShowController;
import com.codurance.training.tasks.Adapter.Controller.UncheckController;
import com.codurance.training.tasks.Presenter.ConsolePresenter;
import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.AddProject.AddProject;
import com.codurance.training.tasks.UseCase.AddTask.AddTask;
import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;
import com.codurance.training.tasks.UseCase.ShowError.ShowError;
import com.codurance.training.tasks.UseCase.ShowHelp.ShowHelp;
import com.codurance.training.tasks.UseCase.ShowProject.ShowProject;

public class CommandControllerFactory {

    private final Map<String, List<GetTaskImpl>> tasks = new LinkedHashMap<>();;

    public CommandControllerFactory() {}

    public ConsolePresenter execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        BaseController selectedAction;
    
        switch (command) {
            case "show":
                ShowProject showProject = new ShowProject();
                selectedAction = new ShowProjectController(showProject);
                break;
            case "add":
                String[] subcommandRest = command.split(" ", 3);
                String subcommand = subcommandRest[1];

                if (subcommand.equals("project")) {
                    AddProject addProject = new AddProject();
                    selectedAction = new AddProjectController(addProject);
                } else {
                    AddTask addTask = new AddTask();
                    selectedAction = new AddTaskController(addTask);                    
                }

                break;
            // case "check":
            //     selectedAction = new CheckController();
            //     break;
            // case "uncheck":
            //     selectedAction = new UncheckController();
            //     break;
            case "help":
                ShowHelp help = new ShowHelp();
                selectedAction = new ShowHelpController(help);
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
