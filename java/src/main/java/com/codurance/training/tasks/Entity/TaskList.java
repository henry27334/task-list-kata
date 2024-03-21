package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.codurance.training.tasks.Entity.ValueObject.ProjectName;

public class TaskList {
    private static TaskList projectList = null;
    private final List<Project> projects;

    private TaskList() {
        this.projects = new ArrayList<>();
    }

    public static TaskList getTaskList() {
        if (projectList == null) {
            projectList = new TaskList();
        } 

        return projectList;
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    public void addProject(ProjectName name) {
        Project project = new Project(name, new ArrayList<>());
        this.projects.add(project);
    }

    public Project getProject(ProjectName projectName) {
        Optional<Project> p =
         projects.stream()
                .filter(project -> project.getProjectName().equals(projectName))
                .findFirst();

        if(p.isEmpty()){
            return null;
        }

        return p.get();
    }

}
