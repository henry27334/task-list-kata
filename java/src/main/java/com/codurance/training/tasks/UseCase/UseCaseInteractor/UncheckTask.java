package com.codurance.training.tasks.UseCase.UseCaseInteractor;

import java.util.List;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.UseCase.InputBoundary.UncheckTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.UncheckTaskOutputBoundary;

public class UncheckTask implements UseCaseInterface<UncheckTaskInputBoundary, UncheckTaskOutputBoundary> {

    @Override
    public UncheckTaskOutputBoundary execute(UncheckTaskInputBoundary input) {
        
        String message = setDone(input.getId(), false);

        UncheckTaskOutputBoundary uncheckTaskOutput = new UncheckTaskOutputBoundary();
        uncheckTaskOutput.setMessage(message);
        
        return uncheckTaskOutput;
    }

    private String setDone(long id, boolean done) {

        TaskList taskList = TaskList.getTaskList();
        List<Project> projects = taskList.getProjects();

        Task task = null;
        String message = null;
        
        for (Project project : projects) {
            task = project.getTask(id);
            task.setDone(done);
            
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
