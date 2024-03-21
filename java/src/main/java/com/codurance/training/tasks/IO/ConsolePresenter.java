package com.codurance.training.tasks.IO;

public class ConsolePresenter {
    private boolean isPresent = false;
    private String message;

    public ConsolePresenter(String message) {
        this.message = message;
    }

    public void setPresentStatus() {
        isPresent = !isPresent;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public String getMessage() {
        return message;
    }
}
