package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.List;

public class Project {  
    private ProjectName projectName; 
    private List<Task> tasks;

    public Project(ProjectName projectName) {
        this.projectName = projectName;
        this.tasks = new ArrayList<>();
    }

    public String getProjectName() {
        return projectName.value();
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
