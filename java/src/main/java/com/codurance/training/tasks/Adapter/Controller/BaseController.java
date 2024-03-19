package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.Presenter.ConsolePresenter;

public interface BaseController {
    ConsolePresenter execute(String command);
}
