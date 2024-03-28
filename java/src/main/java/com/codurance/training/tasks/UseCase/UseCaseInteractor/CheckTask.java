package com.codurance.training.tasks.UseCase.UseCaseInteractor;


import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.Entity.ValueObject.TaskId;
import com.codurance.training.tasks.UseCase.InputBoundary.CheckTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.CheckTaskOutputBoundary;

public class CheckTask implements UseCaseInterface<CheckTaskInputBoundary, CheckTaskOutputBoundary> {

    @Override
    public CheckTaskOutputBoundary execute(CheckTaskInputBoundary input) {
        
        TaskList taskList = TaskList.getTaskList();

        String message = null;
        boolean isCheck = taskList.setTaskDone(TaskId.of(input.getId()), true);
        if (!isCheck) {
            message += String.format("Could not find a task with an ID of %d.", input.getId());
            message += System.lineSeparator();
        }

        CheckTaskOutputBoundary checkTaskOutput = new CheckTaskOutputBoundary();
        checkTaskOutput.setMessage(message);
        
        return checkTaskOutput;
    }

} 
