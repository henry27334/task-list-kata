package com.codurance.training.tasks.Presenter;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.codurance.training.tasks.Controller.CommandController;

public final class TaskListConsole implements Runnable {
    private static final String QUIT = "quit";

    private final BufferedReader in;
    private final PrintWriter out;
    private final CommandController commandController;

    public TaskListConsole(BufferedReader reader, PrintWriter writer, CommandController commandController) {
        this.in = reader;
        this.out = writer;
        this.commandController = commandController;
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

            commandController.execute(command);
        }
    }



}
