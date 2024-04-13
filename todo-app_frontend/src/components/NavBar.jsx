import { Link } from 'react-router-dom';

function NavBar() {
  return (
    <nav>
      <Link to="/">Home</Link> | <Link to="/tasks">Tasks</Link> | <Link to="/add-task">Add Task</Link>
    </nav>
  );
}

export default NavBar;
