package com.codurance.training.tasks.UseCase.Action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.GetTask.GetTask;

public class ErrorAction implements Action {
    @Override
    public void execute(Map<String, List<GetTask>> tasks, PrintWriter out, String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
    
}
