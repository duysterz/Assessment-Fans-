import React, {useState} from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './components/Home';
import About from './components/About';
import Contact from './components/Contact';
import Upload from './components/Upload';
import Login from './components/Login';

function App() {
  const [user, setUser] = useState(null);

  const login = (userData) => {
    setUser(userData);
  };

  const logout = () => {
    setUser(null);
  };

  return (
    <Router>
    <div className="App">
      <Header auth={{ user, login, logout }} />  
      <main className="container">
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/contact" element={<Contact />} />
            <Route path="/upload" element={user ? <Upload /> : null} />
            <Route path="/login" element={<Login auth={{ user, login, logout }} />} />
          </Routes>
        </main>
        {/* <Footer /> */}
      </div>
    </Router>
  );
}

export default App;



    {/* <FilterButtons /> 
          <Routes>
            <Route path="/" element={<ImageGallery />} /> 
          </Routes> */}