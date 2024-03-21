package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.Presenter.ConsolePresenter;
import com.codurance.training.tasks.UseCase.AddTask.AddTask;
import com.codurance.training.tasks.UseCase.InputBoundary.AddTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.AddTaskOutputBoundary;

public class AddTaskController implements BaseController{
    
    private AddTask addTask;

    public AddTaskController(AddTask addTask) {
        this.addTask = addTask;
    }

    @Override
    public ConsolePresenter execute(String command) {

        String[] projectTask = command.split(" ", 4);

        AddTaskInputBoundary addTaskInput = new AddTaskInputBoundary();
        addTaskInput.setProjectName(projectTask[2]);
        addTaskInput.setDescription(projectTask[3]);
        addTaskInput.setCheck(false);
        
        AddTaskOutputBoundary addTaskOutput = addTask.execute(addTaskInput);

        ConsolePresenter consolePresenter = new ConsolePresenter(addTaskOutput.getMessage());
        
        return consolePresenter;
    }

}
