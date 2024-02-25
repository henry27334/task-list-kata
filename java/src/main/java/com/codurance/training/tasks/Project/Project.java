package com.codurance.training.tasks.Project;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Task.Task;

public class Project {

    private final Map<String, List<Task>> projects;

    public Project() {
        projects = new LinkedHashMap<>();
    }
    
    public Map<String, List<Task>> getProject() {
        return projects;
    }

}