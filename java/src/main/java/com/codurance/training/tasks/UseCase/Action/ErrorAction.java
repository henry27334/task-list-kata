package com.codurance.training.tasks.UseCase.Action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;
import com.codurance.training.tasks.UseCase.ShowError.ShowError;
import com.codurance.training.tasks.UseCase.ShowError.ShowErrorImpl;

public class ErrorAction implements Action {
    @Override
    public void execute(Map<String, List<GetTaskImpl>> tasks, PrintWriter out, String command) {
        ShowError showError = new ShowErrorImpl(out, command);
        showError.showErrorMessage();
    }
    
}
