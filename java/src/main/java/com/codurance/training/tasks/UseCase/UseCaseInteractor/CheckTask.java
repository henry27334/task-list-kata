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
        
        TaskList projectList = TaskList.getProjectList();
        List<Project> projects = projectList.getProjects();
        String message = setDone(projects, input.getId(), true);

        CheckTaskOutputBoundary checkTaskOutput = new CheckTaskOutputBoundary();
        checkTaskOutput.setMessage(message);
        
        return checkTaskOutput;
    }

    private String setDone(List<Project> allProjects, long id, boolean done) {
        String message = null;
        
        for (Project project : allProjects) {
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return message;
                }
            }
        }

        message += String.format("Could not find a task with an ID of %d.", id);
        message += "\n";

        return message;
    }

} 
