package com.codurance.training.tasks.UseCase.Action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.AddProject.AddProject;
import com.codurance.training.tasks.UseCase.AddProject.AddProjectImpl;
import com.codurance.training.tasks.UseCase.AddTask.AddTaskImpl;
import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;

public class AddAction implements Action{

    @Override
    public void execute(Map<String, List<GetTaskImpl>> tasks, PrintWriter out, String command) {
        String[] subcommandRest = command.split(" ", 3);
        String subcommand = subcommandRest[1];
        
        if (subcommand.equals("project")) {
            AddProject addProject = new AddProjectImpl(tasks, subcommandRest[2]);
            addProject.addNewProject();
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[2].split(" ", 2);
            AddTaskImpl addTask = new AddTaskImpl(tasks, out, subcommandRest[2], projectTask[1], false);
            addTask.addNewTask();
        }
    }

}
