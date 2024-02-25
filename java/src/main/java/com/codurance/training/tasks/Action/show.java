package com.codurance.training.tasks.Action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Project.Project;
import com.codurance.training.tasks.Task.Task;

public class show extends Action{

    @Override
    public void execute(PrintWriter out, String command) {
        Project newProject = new Project();
        Map<String, List<Task>> tasks = newProject.getProject();

        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            out.println();
        }        
    }
    
}
