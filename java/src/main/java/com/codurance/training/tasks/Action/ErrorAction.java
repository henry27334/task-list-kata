package com.codurance.training.tasks.Action;

import java.io.PrintWriter;

public class ErrorAction extends Action {
    @Override
    public void execute(PrintWriter out, String command) {
        //Default operation
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
    
}
