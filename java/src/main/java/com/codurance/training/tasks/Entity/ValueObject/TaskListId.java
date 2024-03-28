package com.codurance.training.tasks.Entity.ValueObject;

public record TaskListId(String value) {
    public static TaskListId of(String value){
        return new TaskListId(value);
    }
} 
