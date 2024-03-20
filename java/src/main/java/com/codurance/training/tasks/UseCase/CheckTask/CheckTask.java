package com.codurance.training.tasks.UseCase.CheckTask;

import java.util.List;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.Input.CheckTaskInput;
import com.codurance.training.tasks.UseCase.Output.CheckTaskOutput;

public class CheckTask implements UseCaseInterface<CheckTaskInput, CheckTaskOutput> {

    @Override
    public CheckTaskOutput execute(CheckTaskInput input) {
        
        Projects projectList = Projects.getProjectList();
        List<Project> projects = projectList.getProjects();
        String message = setDone(projects, input.getId(), true);

        CheckTaskOutput checkTaskOutput = new CheckTaskOutput();
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
