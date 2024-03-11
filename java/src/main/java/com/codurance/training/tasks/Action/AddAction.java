package com.codurance.training.tasks.Action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Project.Project;
import com.codurance.training.tasks.Task.Task;

public class AddAction implements Action{

    Project pj = Project.getInstance();
    Map<String, List<Task>> tasks = pj.getProject();

    @Override
    public void execute(PrintWriter out, String command) {
        String[] subcommandRest = command.split(" ", 3);
        String subcommand = subcommandRest[1];
        if (subcommand.equals("project")) {
            tasks.put(subcommandRest[2], new ArrayList<Task>());
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[2].split(" ", 2);

            List<Task> projectTasks = tasks.get(projectTask[0]);
            if (projectTasks == null) {
                out.printf("Could not find a project with the name \"%s\".", projectTask[0]);
                out.println();
                return;
            }
    
            long lastId = 0;
            for (Map.Entry<String, List<Task>> allProject : tasks.entrySet()) {
                for (Task task : allProject.getValue()) {
                    lastId = (task.getId() > lastId) ? task.getId() : lastId;
                }
            }
            projectTasks.add(new Task(++lastId, projectTask[1], false));
        }
    }

}
