package com.example.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;

//service/TodoService.java
@Service
public class TodoService {

 @Autowired
 private TodoRepository todoRepository;

 public List<Todo> getAllTodos() {
     return todoRepository.findAll();
 }

 public Todo getTodoById(Long id) {
     return todoRepository.findById(id).orElse(null);
 }

 public Todo createTodo(Todo todo) {
     return todoRepository.save(todo);
 }

 public Todo updateTodo(Long id, Todo todoDetails) {
     Todo todo = todoRepository.findById(id).orElse(null);
     if (todo != null) {
         todo.setTitle(todoDetails.getTitle());
         todo.setDescription(todoDetails.getDescription());
         todo.setCompleted(todoDetails.isCompleted());
         return todoRepository.save(todo);
     }
     return null;
 }

 public void deleteTodo(Long id) {
     todoRepository.deleteById(id);
 }
}

