package com.codurance.training.tasks.Entity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.codurance.training.tasks.Entity.ValueObject.ProjectName;

public class Project {  
    private ProjectName projectName; 
    private final List<Task> tasks;

    public Project(ProjectName projectName, List<Task> tasks) {
        this.projectName = projectName;
        this.tasks = tasks;
    }

    public ProjectName getProjectName() {
        return projectName;
    }
    
    public void addTask(long id, String description, boolean isCheck) {
        Task task = new Task(id, description, isCheck);
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public Task getTask(long id) {
        Optional<Task> task = tasks.stream().filter(t -> t.getId() == id).findFirst();
        
        if(task.isEmpty()) {
            return null;
        }

        return task.get();
    }
    
}
