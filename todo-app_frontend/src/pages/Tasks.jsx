import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const Tasks = () => {
  const [tasks, setTasks] = useState([]);
  const navigate = useNavigate();

  // Fetch tasks from the backend on component mount
  useEffect(() => {
    const fetchTasks = async () => {
      try {
        const response = await fetch('http://localhost:8080/tasks');
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        setTasks(data);
      } catch (error) {
        console.error('Error fetching tasks:', error);
      }
    };

    fetchTasks().catch(console.error);
  }, []);

  // Function to mark a task as complete
  const completeTask = async (taskId) => {
    // ... send request to mark task as complete ...
  };

  // Function to delete a task
  const deleteTask = async (taskId) => {
    // ... send request to delete task ...
  };

  // Render the tasks list
  return (
    <div>
      <h1>Tasks</h1>
      <button onClick={() => navigate('/addTask')}>Add Task</button>
      <ul>
        {tasks.map((task) => (
          <li key={task.taskId}>
            {task.taskName}
            {/* Add buttons or links for completing and deleting tasks */}
            <button onClick={() => completeTask(task.taskId)}>Complete</button>
            <button onClick={() => deleteTask(task.taskId)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Tasks;
