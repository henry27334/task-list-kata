package com.codurance.training.tasks.UseCase.AddTask;

import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;

public interface AddTask {
    Map<String, List<GetTaskImpl>> addNewTask();
}
