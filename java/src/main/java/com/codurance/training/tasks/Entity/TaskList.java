package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.codurance.training.tasks.Entity.ReadOnlyEntity.ReadOnlyProject;
import com.codurance.training.tasks.Entity.ValueObject.ProjectName;
import com.codurance.training.tasks.Entity.ValueObject.TaskId;
import com.codurance.training.tasks.Entity.ValueObject.TaskListId;

public class TaskList {
    private TaskListId taskListId;
    private final List<Project> projects;

    public TaskList(TaskListId id) {
        this.taskListId = id;
        this.projects = new ArrayList<>();
    }

    public TaskListId getId(){
        return taskListId;
    }

    public void addProject(ProjectName name) {
        Project project = new Project(name, new ArrayList<>());
        this.projects.add(project);
    }

    public void addTask(ProjectName name, TaskId id, String description, boolean isCheck){
        Optional<Project> project =
            projects.stream()
                    .filter(pp -> pp.getProjectName().equals(name))
                    .findFirst();

        project.get().addTask(id, description, isCheck);
    }

    public Project getProject(ProjectName projectName) {
        Optional<Project> project =
         projects.stream()
                .map(p -> (Project) new ReadOnlyProject(p.getProjectName(), p.getTasks()))
                .filter(pp -> pp.getProjectName().equals(projectName))
                .findFirst();

        if(project.isEmpty()){
            return null;
        }

        return project.get();
    }

    public List<Project> getProjects() {
        return projects
                .stream()
                .map(p -> (Project) new ReadOnlyProject(p.getProjectName(), p.getTasks()))
                .toList();
    }

    public Boolean setTaskDone(TaskId id, boolean done) {
        Optional<Task> task =
            projects.stream()
            .flatMap(p -> p.getTasks().stream())
            .filter(t -> t.getId().equals(id))
            .findFirst();

        if (task.isEmpty()) {
            return false;
        }

        task.get().setDone(done);

        return true;
    }
}
