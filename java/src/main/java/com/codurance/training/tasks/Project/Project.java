package com.codurance.training.tasks.Project;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Task.Task;

public class Project {

    private static Project instance;
    private final Map<String, List<Task>> tasks;

    private Project() {
        tasks = new LinkedHashMap<>();
    }
    
    public static Project getInstance() {
        if (instance == null) {
            instance = new Project();
        }
        return instance;
    };

    public Map<String, List<Task>> getProject() {
        return tasks;
    };
}