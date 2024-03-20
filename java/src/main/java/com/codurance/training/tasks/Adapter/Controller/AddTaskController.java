package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.Presenter.ConsolePresenter;
import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.AddTask.AddTask;
import com.codurance.training.tasks.UseCase.Input.AddTaskInput;
import com.codurance.training.tasks.UseCase.Output.AddTaskOutput;

public class AddTaskController implements BaseController{
    
    private AddTask addTask;

    public AddTaskController(AddTask addTask) {
        this.addTask = addTask;
    }

    @Override
    public ConsolePresenter execute(String command) {

        AddTaskInput addTaskInput = new AddTaskInput();
        addTaskInput.setProjectName(null);
        addTaskInput.setDescription(null);
        addTaskInput.setCheck(false);
        
        AddTaskOutput addTaskOutput = addTask.execute(addTaskInput);

        ConsolePresenter consolePresenter = new ConsolePresenter(addTaskOutput.getMessage());
        
        return consolePresenter;
    }

}
