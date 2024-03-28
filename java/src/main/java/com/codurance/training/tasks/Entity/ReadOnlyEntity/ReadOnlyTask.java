package com.codurance.training.tasks.Entity.ReadOnlyEntity;

import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.Entity.ValueObject.TaskId;

public class ReadOnlyTask extends Task {

    public ReadOnlyTask(TaskId id, String description, boolean done) {
        super(id, description, done);
    }
    
    @Override
    public void setDone(boolean done) {
        throw new RuntimeException("Cannot modify task because it is readonly");
    } 
}
