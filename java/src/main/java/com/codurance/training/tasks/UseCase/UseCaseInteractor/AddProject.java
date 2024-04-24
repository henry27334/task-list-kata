package com.codurance.training.tasks.UseCase.UseCaseInteractor;

import java.util.Optional;

import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.Entity.ValueObject.TaskListId;
import com.codurance.training.tasks.IO.Repository.ToDoListRepository;
import com.codurance.training.tasks.UseCase.InputBoundary.AddProjectInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.AddProjectOutputBoundary;

public class AddProject implements UseCaseInterface<AddProjectInputBoundary, AddProjectOutputBoundary>{

    private final ToDoListRepository todoListRepository;

    public AddProject(ToDoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public AddProjectOutputBoundary execute(AddProjectInputBoundary input) {

        Optional<TaskList> taskList = todoListRepository.findById(input.getTaskListId());
        taskList.get().addProject(input.getProjectName());

        AddProjectOutputBoundary addProjectOutput = new AddProjectOutputBoundary();

        return addProjectOutput;
    }


}
