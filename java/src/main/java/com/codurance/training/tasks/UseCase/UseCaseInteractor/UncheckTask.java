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
        
        TaskList projectList = TaskList.getProjectList();
        List<Project> projects = projectList.getProjects();
        String message = setDone(projects, input.getId(), false);

        UncheckTaskOutputBoundary uncheckTaskOutput = new UncheckTaskOutputBoundary();
        uncheckTaskOutput.setMessage(message);
        
        return uncheckTaskOutput;
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
