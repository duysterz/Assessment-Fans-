import React, { useState } from 'react';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Calling API auth users
    const data = {
        username: username,
        password: password,
  };

    // call backend API to authenticate user (make sure url is right)
  fetch('http://localhost:8080/api/authenticate', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  })
  .then(response => response.json())
  .then(data => {
    if (data.token) {
        // Stroring JWT token then -> home
        localStorage.setItem('token', data.token);
        window.location.href = '/';
      } else {
        alert('Authentication failed');
    }
  })
  .catch((error) => {
    console.error('Error:', error);
  });
};
  return (
    <div>
      <h1>Login</h1>
      <form onSubmit={handleSubmit}>
        <input 
          type="text" 
          placeholder="Username" 
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <input 
          type="password" 
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
