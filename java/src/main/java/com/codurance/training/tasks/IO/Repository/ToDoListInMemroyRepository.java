package com.codurance.training.tasks.IO.Repository;

import java.util.List;
import java.util.Optional;

import com.codurance.training.tasks.Entity.TaskList;
import com.codurance.training.tasks.Entity.ValueObject.TaskId;

public class ToDoListInMemroyRepository implements TodoListRepository<TaskId> {

    private List<TaskList> taskLists;
    
    @Override
    public Optional<TaskList> findById(TaskId id) {
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
