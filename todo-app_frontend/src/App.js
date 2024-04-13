import "./App.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import { Routes } from "react-router-dom";
import Home from "./components/Home";
import Tasks from "./components/Tasks";
import AddTask from "./components/AddTask";

function App() {
  return (
    <Router>
      <div className="App">
        <switch>
          <Routes>
            <Route exact path="/" component={Home} />
            <Route path="/tasks" component={Tasks} />
            <Route path="/addTask" component={AddTask} />
          </Routes>
        </switch>
      </div>
    </Router>
  );
}

export default App;
