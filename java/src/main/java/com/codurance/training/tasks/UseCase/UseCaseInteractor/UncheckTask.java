package com.codurance.training.tasks.UseCase.UseCaseInteractor;


import java.util.Optional;

import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.Entity.ValueObject.TaskId;
import com.codurance.training.tasks.IO.Repository.ToDoListRepository;
import com.codurance.training.tasks.UseCase.InputBoundary.UncheckTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.UncheckTaskOutputBoundary;

public class UncheckTask implements UseCaseInterface<UncheckTaskInputBoundary, UncheckTaskOutputBoundary> {

    private final ToDoListRepository todoListRepository;

    public UncheckTask(ToDoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }
    

    @Override
    public UncheckTaskOutputBoundary execute(UncheckTaskInputBoundary input) {
        
        Optional<TaskList> taskList = todoListRepository.findById(input.getTaskListId());

        String message = null;
        boolean isCheck = taskList.get().setTaskDone(TaskId.of(input.getId()), false);
        if (!isCheck) {
            message += String.format("Could not find a task with an ID of %s.", input.getId());
            message += System.lineSeparator();
        }

        UncheckTaskOutputBoundary uncheckTaskOutput = new UncheckTaskOutputBoundary();
        uncheckTaskOutput.setMessage(message);
        
        return uncheckTaskOutput;
    }

} 
