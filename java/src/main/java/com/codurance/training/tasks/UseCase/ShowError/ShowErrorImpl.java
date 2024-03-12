package com.codurance.training.tasks.UseCase.ShowError;

import java.io.PrintWriter;

public class ShowErrorImpl implements ShowError{

    private final PrintWriter out;
    private final String command;
    
    public ShowErrorImpl (PrintWriter out, String command) {
        this.out = out;
        this.command = command;
    }

    @Override
    public void showErrorMessage() {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
        
}
