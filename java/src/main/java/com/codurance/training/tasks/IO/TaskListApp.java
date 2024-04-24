package com.codurance.training.tasks.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.codurance.training.tasks.Adapter.CommandController;
import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.Entity.ValueObject.TaskListId;
import com.codurance.training.tasks.IO.Repository.ToDoListInMemroyRepository;
import com.codurance.training.tasks.IO.Repository.ToDoListRepository;

public class TaskListApp {

    public static final TaskListId DEFAULT_TO_DO_LIST_ID = TaskListId.of("001");

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        TaskList taskList = new TaskList(DEFAULT_TO_DO_LIST_ID);
        ToDoListRepository todoListRepository = new ToDoListInMemroyRepository();
        todoListRepository.save(taskList);
        CommandController commandController = new CommandController(todoListRepository);
        new TaskListConsole(in, out, commandController, todoListRepository).run();
    }
}
