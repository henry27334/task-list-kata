package com.codurance.training.tasks.UseCase.AddTask;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.Entity.Task;
import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;

public class AddTaskImpl implements AddTask{

    private final Map<String, List<GetTaskImpl>> tasks;
    private final PrintWriter out;
    private final String tasktName;
    private final String description;
    private final Boolean isDone;

    public AddTaskImpl(Map<String, List<GetTaskImpl>> tasks, PrintWriter out, String tasktName, String description, Boolean isDone) {
        this.tasks = tasks;
        this.out = out;
        this.tasktName = tasktName;
        this.description = description;
        this.isDone = isDone;
    }

    public Map<String, List<GetTaskImpl>> addNewTask() {
        String[] projectTask = tasktName.split(" ", 2);

        List<GetTaskImpl> projectTasks = tasks.get(projectTask[0]);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", projectTask[0]);
            out.println();
            return tasks;
        }

        long lastId = 1;
        for (List<GetTaskImpl> allProject : tasks.values()) {
            lastId += allProject.size();
        }

        Task newTask = new Task(lastId, description, isDone);
        GetTaskImpl getTask = new GetTaskImpl(newTask);
        projectTasks.add(getTask);

        return tasks;
    };

}
