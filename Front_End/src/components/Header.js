import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../App.css';

const Header = () => {
  const [user, setUser] = useState(null);

  const handleLogout = () => {
    setUser(null);  // Reset user -> null on logout
    // more logout logic?
  };

  return (
    <header className="header">
      <h1>Divine Flip Designs</h1>
      <nav>
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/about">About</Link></li>
          <li><Link to="/upload">Upload</Link></li>
          <li><Link to="/contact">Contact</Link></li>
          {/* Conditionally render links */}
          {user === null ? (
            <>
              <li><Link to="/login">Login</Link></li>
              <li><Link to="/register">Register</Link></li>
            </>
          ) : (
            <>
              <li>{user.username}</li>
              <li><button onClick={handleLogout}>Logout</button></li>
            </>
          )}
        </ul>
      </nav>
    </header>
  );
};

export default Header;;
