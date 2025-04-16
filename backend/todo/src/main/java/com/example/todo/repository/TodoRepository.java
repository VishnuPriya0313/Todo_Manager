package com.example.todo.repository;

import com.example.todo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUser(User user);
    List<Todo> findByCompleted(boolean completed);
}

