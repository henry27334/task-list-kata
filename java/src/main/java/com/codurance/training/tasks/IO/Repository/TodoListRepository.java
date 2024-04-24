package com.codurance.training.tasks.IO.Repository;

import java.util.Optional;

import com.codurance.training.tasks.Entity.TaskList;

public interface ToDoListRepository<ID> {
    Optional<TaskList> findById(ID id);
    void save(TaskList toDoList);
}
