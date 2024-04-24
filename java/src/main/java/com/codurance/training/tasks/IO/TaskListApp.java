package com.codurance.training.tasks.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.codurance.training.tasks.Adapter.CommandController;

public class TaskListApp {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        CommandController commandController = new CommandController();
        new TaskListConsole(in, out, commandController).run();
    }
}
