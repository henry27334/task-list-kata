package com.codurance.training.tasks.UseCase.AddProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;

public class AddProjectImpl implements AddProject {

    private final Map<String, List<GetTaskImpl>> tasks;
    private final String projectName;

    public AddProjectImpl(Map<String, List<GetTaskImpl>> tasks, String projectName) {
        this.tasks = tasks;
        this.projectName = projectName;
    }

    @Override
    public void addNewProject() {
        tasks.put(projectName, new ArrayList<GetTaskImpl>());
    }
    
}
