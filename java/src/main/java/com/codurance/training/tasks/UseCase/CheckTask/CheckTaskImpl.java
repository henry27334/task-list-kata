package com.codurance.training.tasks.UseCase.CheckTask;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;

public class CheckTaskImpl implements CheckTask {

    private final Map<String, List<GetTaskImpl>> tasks;
    private final PrintWriter out;
    private final String command;

    public CheckTaskImpl(Map<String, List<GetTaskImpl>> tasks, PrintWriter out, String command) {
        this.tasks = tasks;
        this.out = out;
        this.command = command;
    }

    @Override
    public void checkTask() {
        String[] subcommandRest = command.split(" ", 3);
        String subcommand = subcommandRest[1];
        setDone(tasks, out, subcommand, true);
    }    

    private void setDone(Map<String, List<GetTaskImpl>> tasks, PrintWriter out, String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<GetTaskImpl>> project : tasks.entrySet()) {
            for (GetTaskImpl task : project.getValue()) {
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
