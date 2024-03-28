package com.codurance.training.tasks.Entity.ReadOnlyEntity;

import java.util.List;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.Entity.ValueObject.ProjectName;
import com.codurance.training.tasks.Entity.ValueObject.TaskId;

public class ReadOnlyProject extends Project {

    public ReadOnlyProject(ProjectName projectName, List<Task> tasks) {
        super(projectName, tasks);
    }

    @Override
    public void addTask(TaskId id, String description, boolean isCheck) {
        throw new RuntimeException("Cannot modify task because it is readonly");
    }
    
}
