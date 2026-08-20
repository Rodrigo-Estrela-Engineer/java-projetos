package com.example.projeto_spring.domain;

import java.util.Optional;
import java.util.List;

public interface TaskRepository{

    Task save(Task task);
    List<Task> findAll();
    Optional<Task> findById(TaskId id);
    void delete(TaskId id);
    
}