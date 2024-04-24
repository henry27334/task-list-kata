package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.IO.MessagePresenter;
import com.codurance.training.tasks.UseCase.InputBoundary.AddTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.AddTaskOutputBoundary;
import com.codurance.training.tasks.UseCase.UseCaseInteractor.AddTask;

public class AddTaskController implements BaseController{
    
    private AddTask addTask;

    public AddTaskController(AddTask addTask) {
        this.addTask = addTask;
    }

    @Override
    public MessagePresenter execute(String command) {

        String[] projectTask = command.split(" ", 4);

        AddTaskInputBoundary addTaskInput = new AddTaskInputBoundary();
        addTaskInput.setProjectName(projectTask[2]);
        addTaskInput.setDescription(projectTask[3]);
        addTaskInput.setCheck(false);
        addTaskInput.setTaskListId("001");
        
        AddTaskOutputBoundary addTaskOutput = addTask.execute(addTaskInput);

        MessagePresenter consolePresenter = new MessagePresenter(addTaskOutput.getMessage());
        
        return consolePresenter;
    }

}
