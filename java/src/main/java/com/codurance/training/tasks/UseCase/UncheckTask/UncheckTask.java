package com.codurance.training.tasks.UseCase.UncheckTask;

import java.util.List;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.Input.UncheckTaskInput;
import com.codurance.training.tasks.UseCase.Output.UncheckTaskOutput;

public class UncheckTask implements UseCaseInterface<UncheckTaskInput, UncheckTaskOutput> {


    @Override
    public UncheckTaskOutput execute(UncheckTaskInput input) {
        
        Projects projectList = Projects.getProjectList();
        List<Project> projects = projectList.getProjects();
        String message = setDone(projects, input.getId(), false);

        UncheckTaskOutput uncheckTaskOutput = new UncheckTaskOutput();
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
