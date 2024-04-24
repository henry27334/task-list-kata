package com.codurance.training.tasks.UseCase.UseCaseInteractor;


import java.util.Optional;

import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.Entity.ValueObject.TaskId;
import com.codurance.training.tasks.IO.Repository.ToDoListRepository;
import com.codurance.training.tasks.UseCase.InputBoundary.CheckTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.CheckTaskOutputBoundary;

public class CheckTask implements UseCaseInterface<CheckTaskInputBoundary, CheckTaskOutputBoundary> {

    
    private final ToDoListRepository todoListRepository;

    public CheckTask(ToDoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public CheckTaskOutputBoundary execute(CheckTaskInputBoundary input) {
        
        Optional<TaskList> taskList = todoListRepository.findById(input.getTaskListId());

        String message = null;
        boolean isCheck = taskList.get().setTaskDone(TaskId.of(input.getId()), true);
        if (!isCheck) {
            message += String.format("Could not find a task with an ID of %d.", input.getId());
            message += System.lineSeparator();
        }

        CheckTaskOutputBoundary checkTaskOutput = new CheckTaskOutputBoundary();
        checkTaskOutput.setMessage(message);
        
        return checkTaskOutput;
    }

} 
