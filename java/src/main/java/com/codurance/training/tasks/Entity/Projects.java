package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.List;

public class Projects {
    private static List<Project> projects = null;

    public Projects() {
        projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return projects;
    }

}
