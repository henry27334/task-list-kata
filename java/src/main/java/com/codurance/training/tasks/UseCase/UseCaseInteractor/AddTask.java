package com.codurance.training.tasks.UseCase.UseCaseInteractor;


import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.Entity.Service.CountingTaskId;
import com.codurance.training.tasks.Entity.ValueObject.TaskId;
import com.codurance.training.tasks.UseCase.InputBoundary.AddTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.AddTaskOutputBoundary;

public class AddTask implements UseCaseInterface<AddTaskInputBoundary, AddTaskOutputBoundary>{

    @Override
    public AddTaskOutputBoundary execute(AddTaskInputBoundary input) {

        String message = null;
        
        TaskList projects = TaskList.getTaskList();
        Project project = projects.getProject(input.getProjectName());

        if (project == null) {
            message += String.format("Could not find a project with the name \"%s\".", input.getProjectName());
            message += System.lineSeparator();
        }

        TaskId lastId = TaskId.of(CountingTaskId.getLastId(projects));
        projects.addTask(input.getProjectName(), lastId, input.getDescription(), false);

        AddTaskOutputBoundary addTaskOutput = new AddTaskOutputBoundary();
        addTaskOutput.setMessage(message);

        return addTaskOutput;
    }
}
