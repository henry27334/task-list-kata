package com.codurance.training.tasks.UseCase.ShowProject;

import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;
import com.codurance.training.tasks.UseCase.Input.ShowProjectInput;
import com.codurance.training.tasks.UseCase.Output.ShowProjectOutput;

public class ShowProject implements UseCaseInterface<ShowProjectInput, ShowProjectOutput>{

    @Override
    public ShowProjectOutput execute(ShowProjectInput input) {

        Projects projects = new Projects();
        List<Project> allProject = projects.getProjects();
        String message = null;

        for (Project project : allProject) {
            message = project.getProjectName();
            for (Task task : project.getTasks()) {
                message += "\n";
                message += String.format("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            message += "\n";
        } 

        ShowProjectOutput showProjectOutput = new ShowProjectOutput();
        showProjectOutput.setMessage(message);

        return showProjectOutput;
    }

}