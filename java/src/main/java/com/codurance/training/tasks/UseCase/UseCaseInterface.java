package com.codurance.training.tasks.UseCase;

import com.codurance.training.tasks.UseCase.InputBoundary.UseCaseInputBoundary;
import com.codurance.training.tasks.UseCase.OutputBoundary.UseCaseOutputBoundary;

public interface UseCaseInterface<useCaseInput extends UseCaseInputBoundary, useCaseOutput extends UseCaseOutputBoundary> {
    useCaseOutput execute(useCaseInput input);
}
