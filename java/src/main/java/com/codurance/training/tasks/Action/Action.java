package com.codurance.training.tasks.Action;

import java.io.PrintWriter;

public abstract class Action {
    void execute(PrintWriter out, String command) {
        //Default operation
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    };
}
