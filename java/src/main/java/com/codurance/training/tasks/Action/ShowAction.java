package com.codurance.training.tasks.Action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Project.Project;
import com.codurance.training.tasks.Task.Task;

public class ShowAction implements Action{

    @Override
    public void execute(PrintWriter out, String command) {
        Project pj = Project.getInstance();
        Map<String, List<Task>> tasks = pj.getProject();

        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }        
    }
    
}