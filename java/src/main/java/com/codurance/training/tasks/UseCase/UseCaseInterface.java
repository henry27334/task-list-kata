package com.codurance.training.tasks.UseCase;

import com.codurance.training.tasks.UseCase.Input.UseCaseInput;
import com.codurance.training.tasks.UseCase.Output.UseCaseOutput;

public interface UseCaseInterface<useCaseInput extends UseCaseInput, useCaseOutput extends UseCaseOutput> {
    useCaseOutput execute(useCaseInput input);
}
