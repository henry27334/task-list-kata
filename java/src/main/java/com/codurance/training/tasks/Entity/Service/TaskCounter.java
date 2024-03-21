package com.codurance.training.tasks.Entity.Service;

import java.util.List;

import com.codurance.training.tasks.Entity.Project;
import com.codurance.training.tasks.Entity.TaskList;

public class TaskCounter {
    public static long getLastId(TaskList tasklist) {

        List<Project> allProject = tasklist.getProjects();

        long lastId = 1;
        for (Project singleProject : allProject) {
            lastId += singleProject.getTasks().size();
        }

        return lastId;
    }
}
