package com.codurance.training.tasks.Adapter;


import com.codurance.training.tasks.Adapter.Controller.AddProjectController;
import com.codurance.training.tasks.Adapter.Controller.AddTaskController;
import com.codurance.training.tasks.Adapter.Controller.BaseController;
import com.codurance.training.tasks.Adapter.Controller.CheckController;
import com.codurance.training.tasks.Adapter.Controller.ShowErrorController;
import com.codurance.training.tasks.Adapter.Controller.ShowHelpController;
import com.codurance.training.tasks.Adapter.Controller.ShowProjectController;
import com.codurance.training.tasks.Adapter.Controller.UncheckController;
import com.codurance.training.tasks.IO.MessagePresenter;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.AddProject;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.AddTask;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.CheckTask;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.ShowError;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.ShowHelp;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.ShowProject;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.UncheckTask;

public class CommandController {

    public MessagePresenter execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        BaseController selectedAction;
    
        switch (command) {
            case "show":
                ShowProject showProject = new ShowProject();
                selectedAction = new ShowProjectController(showProject);
                break;
            case "add":
                String[] subcommandRest = commandRest[1].split(" ", 3);
                String subcommand = subcommandRest[0];

                if (subcommand.equals("project")) {
                    AddProject addProject = new AddProject();
                    selectedAction = new AddProjectController(addProject);
                } else {
                    AddTask addTask = new AddTask();
                    selectedAction = new AddTaskController(addTask);                    
                }
                break;
            case "check":
                CheckTask checkTask = new CheckTask();
                selectedAction = new CheckController(checkTask);
                break;
            case "uncheck":
                UncheckTask uncheckTask = new UncheckTask();
                selectedAction = new UncheckController(uncheckTask);
                break;
            case "help":
                ShowHelp help = new ShowHelp();
                selectedAction = new ShowHelpController(help);
                break;
            default:
                ShowError showError = new ShowError();
                selectedAction = new ShowErrorController(showError);
                break;

        }
        
        MessagePresenter consolePresenter = selectedAction.execute(commandLine);
        
        return consolePresenter;
    }    
}
