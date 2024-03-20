package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.List;

public class Projects {
    private static Projects projectList = null;
    private final List<Project> projects;

    private Projects() {
        this.projects = new ArrayList<>();
    }

    public static Projects getProjectList() {
        if (projectList == null) {
            projectList = new Projects();
        } 

        return projectList;
    }

    public List<Project> getProjects() {
        return projects;
    }

}
