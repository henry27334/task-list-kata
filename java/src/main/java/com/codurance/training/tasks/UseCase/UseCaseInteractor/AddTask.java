package com.codurance.training.tasks.UseCase.UseCaseInteractor;


import java.util.Optional;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.Entity.Service.CountingTaskId;
import com.codurance.training.tasks.Entity.ValueObject.TaskId;
import com.codurance.training.tasks.IO.Repository.ToDoListRepository;
import com.codurance.training.tasks.UseCase.InputBoundary.AddTaskInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.AddTaskOutputBoundary;

public class AddTask implements UseCaseInterface<AddTaskInputBoundary, AddTaskOutputBoundary>{

    private final ToDoListRepository todoListRepository;

    public AddTask(ToDoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public AddTaskOutputBoundary execute(AddTaskInputBoundary input) {

        String message = null;

        Optional<TaskList> taskList = todoListRepository.findById(input.getTaskListId());
        Project project = taskList.get().getProject(input.getProjectName());

        if (project == null) {
            message += String.format("Could not find a project with the name \"%s\".", input.getProjectName());
            message += System.lineSeparator();
        }

        TaskId lastId = TaskId.of(CountingTaskId.getLastId(taskList.get()));
        taskList.get().addTask(input.getProjectName(), lastId, input.getDescription(), false);

        AddTaskOutputBoundary addTaskOutput = new AddTaskOutputBoundary();
        addTaskOutput.setMessage(message);

        return addTaskOutput;
    }
}
