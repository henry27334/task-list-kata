package com.codurance.training.tasks.Action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Project.Project;
import com.codurance.training.tasks.Task.Task;

public class CheckAction extends Action{

    Project pj = Project.getInstance();
    Map<String, List<Task>> tasks = pj.getProject();

    @Override
    public void execute(PrintWriter out, String command) {
        String[] subcommandRest = command.split(" ", 3);
        String subcommand = subcommandRest[1];
        setDone(out, subcommand, true);
    }
    
    private void setDone(PrintWriter out, String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
