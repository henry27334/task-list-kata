package com.codurance.training.tasks.Presenter;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.Action.Action;
import com.codurance.training.tasks.UseCase.Action.AddAction;
import com.codurance.training.tasks.UseCase.Action.CheckAction;
import com.codurance.training.tasks.UseCase.Action.ErrorAction;
import com.codurance.training.tasks.UseCase.Action.HelpAction;
import com.codurance.training.tasks.UseCase.Action.ShowAction;
import com.codurance.training.tasks.UseCase.Action.UncheckAction;
import com.codurance.training.tasks.UseCase.GetTask.GetTask;

public final class TaskListConsole implements Runnable {
    private static final String QUIT = "quit";

    private final BufferedReader in;
    private final PrintWriter out;
    private final Map<String, List<GetTask>> tasks = new LinkedHashMap<>();;

    public TaskListConsole(BufferedReader reader, PrintWriter writer) {
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
        
        selectedAction.execute(tasks, out, commandLine);

    }

}
