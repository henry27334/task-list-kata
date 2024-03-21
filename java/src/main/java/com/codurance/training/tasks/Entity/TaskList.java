package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private static TaskList projectList = null;
    private final List<Project> projects;

    private TaskList() {
        this.projects = new ArrayList<>();
    }

    public static TaskList getProjectList() {
        if (projectList == null) {
            projectList = new TaskList();
        } 

        return projectList;
    }

    public List<Project> getProjects() {
        return projects;
    }

}
