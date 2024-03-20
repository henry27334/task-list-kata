package com.codurance.training.tasks.UseCase.AddTask;


import java.util.List;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Projects;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.UseCase.UseCaseInterface;
import com.codurance.training.tasks.UseCase.Input.AddTaskInput;
import com.codurance.training.tasks.UseCase.Output.AddTaskOutput;

public class AddTask implements UseCaseInterface<AddTaskInput, AddTaskOutput>{

    @Override
    public AddTaskOutput execute(AddTaskInput input) {

        String message = null;
        Projects projects = Projects.getProjectList();
        List<Project> allProject = projects.getProjects();

        Project projectTasks = null;

        for(Project singleProject : allProject){
            if (singleProject.getProjectName().equals(input.getProjectName())) {
                projectTasks = singleProject;
            }
        }

        long lastId = 1;
        for (Project singleProject : allProject) {
            lastId += singleProject.getTasks().size();
        }

        if (projectTasks == null) {
            message += String.format("Could not find a project with the name \"%s\".", input.getProjectName());
            message += "\n";
        }

        Task newTask = new Task(lastId, input.getDescription(), input.getCheck());
        projectTasks.getTasks().add(newTask);

        AddTaskOutput addTaskOutput = new AddTaskOutput();
        addTaskOutput.setMessage(message);

        return addTaskOutput;
    }
}
