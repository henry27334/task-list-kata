package com.codurance.training.tasks.UseCase.GetTask;

import com.codurance.training.tasks.Entity.Task;

public class GetTaskImpl implements GetTask{
    private final Task task;

    public GetTaskImpl(Task task){
        this.task = task;
    }

    public Task getTask(){
        return task;
    }
}
