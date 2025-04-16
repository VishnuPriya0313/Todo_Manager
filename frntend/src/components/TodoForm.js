import React, { useState } from 'react';
import '../TodoForm.css';


function TodoForm({ refreshTodos }) {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  
  const handleSubmit = async (e) => {
    e.preventDefault();
    
    const newTodo = { title, description, completed: false};
    
    try {
        const response = await fetch("http://localhost:8081/api/todos", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(newTodo)
        });
        if (!response.ok) throw new Error("Failed to create todo");

        const created = await response.json();
        refreshTodos(created); // Tell parent to update list
  
        setTitle("");
        setDescription("");
      } catch (err) {
        alert(err.message);
      }
    };

  return (
    <form className="todo-form" onSubmit={handleSubmit}>
    <label>Task:</label>
    <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
  
    <label>What to do:</label>
    <textarea value={description} onChange={(e) => setDescription(e.target.value)} />
  
    <button type="submit">Add Task</button>
  </form>  
  );
}

export default TodoForm;
