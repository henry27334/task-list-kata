package com.codurance.training.tasks.UseCase.Action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.AddTask.AddTask;
import com.codurance.training.tasks.UseCase.GetTask.GetTask;

public class AddAction implements Action{

    @Override
    public void execute(Map<String, List<GetTask>> tasks, PrintWriter out, String command) {
        String[] subcommandRest = command.split(" ", 3);
        String subcommand = subcommandRest[1];
        
        if (subcommand.equals("project")) {
            tasks.put(subcommandRest[2], new ArrayList<GetTask>());
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[2].split(" ", 2);
            
            AddTask addTask = new AddTask();
            addTask.addNewTask(tasks, subcommandRest[2], projectTask[1], false);
        }
    }

}
