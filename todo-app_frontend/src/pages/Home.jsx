import React from 'react';
import { useNavigate } from 'react-router-dom';

function Home() {
  const navigate = useNavigate();

  return (
    <div className="home-container">
      <h1>Welcome to ToDo App!</h1>
      <p>Organize your life with ease and efficiency.</p>
      <button onClick={() => navigate('/tasks')} className="start-button">
        Get Started
      </button>
      <div className="features">
        <h2>Features:</h2>
        <ul>
          <li>Create daily tasks</li>
          <li>Mark tasks as completed</li>
          <li>View all your tasks in one place</li>
          {/* List other features */}
        </ul>
      </div>
      {/* Any additional content or graphics */}
    </div>
  );
}

export default Home;
