package com.example.projeto_spring.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import com.example.projeto_spring.domain.Task;
import com.example.projeto_spring.domain.TaskId;
import com.example.projeto_spring.domain.TaskRepository;


public class InMemoryTaskRepository implements TaskRepository {
    private final Map<TaskId, Task> storage = new HashMap<>();

    @Override
    public Task save(Task task){
        storage.put(task.getId(), task);
        return task;
    }

    @Override
    public List<Task> findAll(){
        return new ArrayList<>(storage.values());
    }
    
    @Override
    public Optional<Task> findById(TaskId id){
        return Optional.ofNullable(storage.get(id));
    }
    
    @Override
    public void delete(TaskId id){
        storage.remove(id);
    }

}