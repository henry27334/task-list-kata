package com.codurance.training.tasks.UseCase.AddTask;

import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Entity.Task.Task;
import com.codurance.training.tasks.UseCase.GetTask.GetTask;

public class AddTask {

    public AddTask() {
    }

    public Map<String, List<GetTask>> addNewTask(Map<String, List<GetTask>> tasks, String projectName, String description, Boolean isDone) {
        String[] projectTask = projectName.split(" ", 2);

        List<GetTask> projectTasks = tasks.get(projectTask[0]);
        if (projectTasks == null) {
            System.out.printf("Could not find a project with the name \"%s\".", projectTask[0]);
            System.out.println();
            return tasks;
        }

        long lastId = 1;
        for (Map.Entry<String, List<GetTask>> allProject : tasks.entrySet()) {
            for (GetTask task : allProject.getValue()) {
                lastId++;
            }
        }

        Task newTask = new Task(lastId, description, isDone);
        GetTask getTask = new GetTask(newTask);
        projectTasks.add(getTask);

        return tasks;
    };

}
