package com.codurance.training.tasks.Adapter.Controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.UseCase.CheckTask.CheckTask;
import com.codurance.training.tasks.UseCase.CheckTask.CheckTaskImpl;
import com.codurance.training.tasks.UseCase.GetTask.GetTaskImpl;

public class CheckController implements BaseController {

    @Override
    public void execute(Map<String, List<GetTaskImpl>> tasks, PrintWriter out, String command) {
        CheckTask checkTask = new CheckTaskImpl(tasks, out, command);
        checkTask.checkTask();
    }
    

}
