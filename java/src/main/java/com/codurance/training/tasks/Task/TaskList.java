package com.codurance.training.tasks.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.codurance.training.tasks.Action.Action;
import com.codurance.training.tasks.Action.AddAction;
import com.codurance.training.tasks.Action.CheckAction;
import com.codurance.training.tasks.Action.ErrorAction;
import com.codurance.training.tasks.Action.HelpAction;
import com.codurance.training.tasks.Action.ShowAction;
import com.codurance.training.tasks.Action.UncheckAction;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";

    private final BufferedReader in;
    private final PrintWriter out;

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        Action selectedAction;
    
        switch (command) {
            case "show":
                selectedAction = new ShowAction();
                break;
            case "add":
                selectedAction = new AddAction();
                break;
            case "check":
                selectedAction = new CheckAction();
                break;
            case "uncheck":
                selectedAction = new UncheckAction();
                break;
            case "help":
                selectedAction = new HelpAction();
                break;
            default:
                selectedAction = new ErrorAction();
                break;

        }
        
        selectedAction.execute(out, commandLine);

    }

}
