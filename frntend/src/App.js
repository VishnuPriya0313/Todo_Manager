import React, { useState } from 'react';
import TodoList from './components/TodoList';
import TodoForm from './components/TodoForm';
import './App.css';

function App() {
  const [todos, setTodos] = useState(false);

  // Refresh the todo list after adding a new todo
  const refreshTodos = () => {
    setTodos(!todos);
  };

  const fetchTodos = async () => {
    try {
      const response = await fetch("http://localhost:8081/api/todos");
      const data = await response.json();
      setTodos(data);
    } catch (err) {
      console.error("Failed to fetch todos:", err);
    }
  };

  const handleTodoAdded = (newTodo) => {
    setTodos((prev) => [...prev, newTodo]);
  };

  return (
    <div className="todo-container">
      <header className="todo-header">
        <h1>TODO Manager</h1>
      </header>

      <section className="todo-form-section">
        <TodoForm refreshTodos={refreshTodos} />
      </section>

      <section className="todo-list-section">
        <TodoList key={todos} />
      </section>
    </div>
  );
}

export default App;
