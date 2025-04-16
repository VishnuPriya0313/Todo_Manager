import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../TodoList.css';

function TodoList() {
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    // Fetch todos when component mounts
    axios.get('/api/todos"')
      .then(response => {
        setTodos(response.data);
      })
      .catch(error => {
        console.error("There was an error fetching the todos:", error);
      });
  }, []);

  return (
    <div className="todo-list">
    <h3>Todo List</h3>
    {todos.map((todo, index) => (
        <div key={index}>
        <strong>{todo.title}</strong>: {todo.description}
        </div>
    ))}
    </div>
  );
}

export default TodoList;
