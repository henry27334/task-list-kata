package com.codurance.training.tasks.UseCase.ShowProject;

import java.util.List;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.InputBoundary.ShowProjectInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.ShowProjectOutputBoundary;

public class ShowProject implements UseCaseInterface<ShowProjectInputBoundary, ShowProjectOutputBoundary>{

    @Override
    public ShowProjectOutputBoundary execute(ShowProjectInputBoundary input) {

        Projects projects = Projects.getProjectList();
        List<Project> allProject = projects.getProjects();

        String message = null;

        for (Project project : allProject) {
            if(message == null && project.getProjectName() != null) {
                message = project.getProjectName();
            } else {
                message += project.getProjectName();
            }
            
            message += "\r\n";
            
            for (Task task : project.getTasks()) {
                message += String.format("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }

            message += "\n";
        } 

        ShowProjectOutputBoundary showProjectOutput = new ShowProjectOutputBoundary();
        showProjectOutput.setMessage(message);

        return showProjectOutput;
    }

}