package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.IO.ConsolePresenter;

public interface BaseController {
    ConsolePresenter execute(String command);
}
