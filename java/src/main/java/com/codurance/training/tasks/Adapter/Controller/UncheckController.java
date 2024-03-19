package com.codurance.training.tasks.Adapter.Controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;
import com.codurance.training.tasks.UseCase.UncheckTask.UncheckTask;
import com.codurance.training.tasks.UseCase.UncheckTask.UncheckTaskImpl;

public class UncheckController implements BaseController{

    @Override
    public void execute(Map<String, List<GetTaskImpl>> tasks, PrintWriter out, String command) {
        UncheckTask uncheckTask = new UncheckTaskImpl(tasks, out, command);
        uncheckTask.unsetCheck();
    }
    

}
