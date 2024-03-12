package com.codurance.training.tasks.UseCase.Action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.GetTask.GetTask;

public class CheckAction implements Action {

    @Override
    public void execute(Map<String, List<GetTask>> tasks, PrintWriter out, String command) {
        String[] subcommandRest = command.split(" ", 3);
        String subcommand = subcommandRest[1];
        setDone(tasks, out, subcommand, true);
    }
    
    private void setDone(Map<String, List<GetTask>> tasks, PrintWriter out, String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<GetTask>> project : tasks.entrySet()) {
            for (GetTask task : project.getValue()) {
                if (task.getTask().getId() == id) {
                    task.getTask().setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
