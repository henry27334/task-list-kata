package com.codurance.training.tasks.UseCase.UseCaseInteractor;

import java.util.List;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.UseCase.InputBoundary.CheckTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.CheckTaskOutputBoundary;

public class CheckTask implements UseCaseInterface<CheckTaskInputBoundary, CheckTaskOutputBoundary> {

    @Override
    public CheckTaskOutputBoundary execute(CheckTaskInputBoundary input) {
        
        String message = setDone(input.getId(), true);

        CheckTaskOutputBoundary checkTaskOutput = new CheckTaskOutputBoundary();
        checkTaskOutput.setMessage(message);
        
        return checkTaskOutput;
    }

    private String setDone(long id, boolean done) {

        TaskList taskList = TaskList.getTaskList();
        List<Project> projects = taskList.getProjects();

        Task task = null;
        String message = null;
        
        for (Project project : projects) {
            task = project.getTask(id);

            if (task != null) {
                task.setDone(done);
                break;
            }
        }

        if (task == null) {
            message += String.format("Could not find a task with an ID of %d.", id);
            message += "\n";
        }

        return message;
    }

} 
