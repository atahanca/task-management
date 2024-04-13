import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <switch>
          <Router>
            <Route exact path="/" component={Home} />
            <Route path="/tasks" component={Tasks} />
            <Route path="/addTask" component={AddTask} />
          </Router>
         
        </switch>
        </div>
      </Router>
    
  );
}

export default App;
