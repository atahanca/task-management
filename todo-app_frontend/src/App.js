import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/Home'; // Ensure this path is correct
import Tasks from './pages/Tasks'; // Ensure this path is correct
import AddTask from './components/AddTask'; // Ensure this path is correct

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/tasks" element={<Tasks />} />
          <Route path="/addTask" element={<AddTask />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
