package com.codurance.training.tasks.Adapter.Controller;

import com.codurance.training.tasks.IO.MessagePresenter;

public interface BaseController {
    MessagePresenter execute(String command);
}
