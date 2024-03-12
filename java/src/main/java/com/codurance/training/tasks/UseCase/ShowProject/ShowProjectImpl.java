package com.codurance.training.tasks.UseCase.ShowProject;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;

public class ShowProjectImpl implements ShowProject {

    private final Map<String, List<GetTaskImpl>> tasks;
    private final PrintWriter out;
    
    public ShowProjectImpl (Map<String, List<GetTaskImpl>> tasks, PrintWriter out) {
        this.tasks = tasks;
        this.out = out;
    }

    @Override
    public void showDetail() {
        for (Map.Entry<String, List<GetTaskImpl>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (GetTaskImpl task : project.getValue()) {
                out.printf("    [%c] %d: %s%n", (task.getTask().isDone() ? 'x' : ' '), task.getTask().getId(), task.getTask().getDescription());
            }
            out.println();
        }       
    }
    
}
