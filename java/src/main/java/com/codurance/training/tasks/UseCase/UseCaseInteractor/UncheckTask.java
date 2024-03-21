package com.codurance.training.tasks.UseCase.UseCaseInteractor;


import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.UseCase.InputBoundary.UncheckTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.UncheckTaskOutputBoundary;

public class UncheckTask implements UseCaseInterface<UncheckTaskInputBoundary, UncheckTaskOutputBoundary> {

    @Override
    public UncheckTaskOutputBoundary execute(UncheckTaskInputBoundary input) {
        
        TaskList taskList = TaskList.getTaskList();

        String message = null;
        boolean isCheck = taskList.setDone(input.getId(), false);
        if (!isCheck) {
            message += String.format("Could not find a task with an ID of %d.", input.getId());
            message += System.lineSeparator();
        }

        UncheckTaskOutputBoundary uncheckTaskOutput = new UncheckTaskOutputBoundary();
        uncheckTaskOutput.setMessage(message);
        
        return uncheckTaskOutput;
    }

} 
