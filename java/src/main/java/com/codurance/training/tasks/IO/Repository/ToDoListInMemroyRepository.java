package com.codurance.training.tasks.IO.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.Entity.ValueObject.TaskListId;

public class ToDoListInMemroyRepository implements ToDoListRepository<TaskListId> {

    private List<TaskList> taskLists = new ArrayList<>();
    
    @Override
    public Optional<TaskList> findById(TaskListId id) {
        return taskLists.stream()
                        .filter(a -> a.getId().equals(id))
                        .findFirst();
    }

    @Override
    public void save(TaskList toDoList) {
        taskLists.remove(toDoList);
        taskLists.add(toDoList);
    }
    
}
