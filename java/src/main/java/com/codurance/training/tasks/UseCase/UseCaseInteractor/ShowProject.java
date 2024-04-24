package com.codurance.training.tasks.UseCase.UseCaseInteractor;

import java.util.List;
import java.util.Optional;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.IO.Repository.ToDoListRepository;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.UseCase.InputBoundary.ShowProjectInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.ShowProjectOutputBoundary;

public class ShowProject implements UseCaseInterface<ShowProjectInputBoundary, ShowProjectOutputBoundary>{

    private final ToDoListRepository todoListRepository;

    public ShowProject(ToDoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }
    
    @Override
    public ShowProjectOutputBoundary execute(ShowProjectInputBoundary input) {

        Optional<TaskList> taskList = todoListRepository.findById(input.getTaskListId());
        ShowProjectOutputBoundary showProjectOutput = new ShowProjectOutputBoundary();
        String message = null;

        List<Project> allProject = taskList.get().getProjects();

        for (Project project : allProject) {
            if(message == null && project.getProjectName() != null) {
                message = project.getProjectName().value();
            } else {
                message += project.getProjectName().value();
            }
            
            message += System.lineSeparator();
            
            for (Task task : project.getTasks()) {
                message += String.format("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }

            message += System.lineSeparator();
        } 

        showProjectOutput.setMessage(message);

        return showProjectOutput;
    }

}