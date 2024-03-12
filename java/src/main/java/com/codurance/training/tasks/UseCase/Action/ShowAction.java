package com.codurance.training.tasks.UseCase.Action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.GetTask.GetTask;

public class ShowAction implements Action{

    @Override
    public void execute(Map<String, List<GetTask>> tasks, PrintWriter out, String command) {

        for (Map.Entry<String, List<GetTask>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (GetTask task : project.getValue()) {
                out.printf("    [%c] %d: %s%n", (task.getTask().isDone() ? 'x' : ' '), task.getTask().getId(), task.getTask().getDescription());
            }
            out.println();
        }        
    }
    
}
