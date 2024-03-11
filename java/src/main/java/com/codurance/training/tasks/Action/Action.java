package com.codurance.training.tasks.Action;

import java.io.PrintWriter;

public interface Action {
    void execute(PrintWriter out, String command);
}
