package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;

//controller/TodoController.java
@RestController
@RequestMapping("/api/todos")
public class TodoController {

 @Autowired
 private TodoService todoService;

 @GetMapping
 public List<Todo> getAllTodos() {
     return todoService.getAllTodos();
 }

 @GetMapping("/{id}")
 public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
     Todo todo = todoService.getTodoById(id);
     return todo != null ? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
 }

 @PostMapping
 public Todo createTodo(@RequestBody Todo todo) {
     return todoService.createTodo(todo);
 }

 @PutMapping("/{id}")
 public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
     Todo updatedTodo = todoService.updateTodo(id, todoDetails);
     return updatedTodo != null ? ResponseEntity.ok(updatedTodo) : ResponseEntity.notFound().build();
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
     todoService.deleteTodo(id);
     return ResponseEntity.noContent().build();
 }
}

