package com.codurance.training.tasks.Action;

import java.io.PrintWriter;

public class HelpAction extends Action{
    @Override
    public void execute(PrintWriter out, String command) {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }
}
