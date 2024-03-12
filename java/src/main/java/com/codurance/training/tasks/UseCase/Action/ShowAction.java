package com.codurance.training.tasks.UseCase.Action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;
import com.codurance.training.tasks.UseCase.ShowProject.ShowProject;
import com.codurance.training.tasks.UseCase.ShowProject.ShowProjectImpl;

public class ShowAction implements Action{

    @Override
    public void execute(Map<String, List<GetTaskImpl>> tasks, PrintWriter out, String command) {
        ShowProject showProject = new ShowProjectImpl(tasks, out);
        showProject.showDetail();
    }
    
}
