package com.codurance.training.tasks.UseCase.GetTask;

import com.codurance.training.tasks.Entity.Task.Task;

public class GetTask {
    private final Task task;

    public GetTask(Task task){
        this.task = task;
    }

    public Task getTask(){
        return task;
    }
}
