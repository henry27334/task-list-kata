package com.codurance.training.tasks.Action;

import java.io.PrintWriter;

public abstract class Action {
    public abstract void execute(PrintWriter out, String command);
}
