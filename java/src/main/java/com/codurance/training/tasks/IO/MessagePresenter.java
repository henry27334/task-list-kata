package com.codurance.training.tasks.IO;

public class MessagePresenter {
    private boolean isPresent = false;
    private String message;

    public MessagePresenter(String message) {
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
