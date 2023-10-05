import React from 'react';
import { Link } from 'react-router-dom';  
import '../App.css';

const Header = () => {
  return (
    <header className="header">
      <h1>Interior Design Fansite</h1>
      <nav>
        <ul>
          <li><Link to="/">Home</Link></li> 
          <li><Link to="/about">About</Link></li> 
          <li><Link to="/contact">Contact</Link></li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
