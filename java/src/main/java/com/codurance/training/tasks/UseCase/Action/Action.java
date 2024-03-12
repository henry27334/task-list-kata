package com.codurance.training.tasks.UseCase.Action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;

public interface Action {
    void execute(Map<String, List<GetTaskImpl>> tasks, PrintWriter out, String command);
}
