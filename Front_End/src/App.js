import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './components/Home';  
import About from './components/About'; 
import Contact from './components/Contact';
// import ImageGallery from './components/ImageGallery'; 
// import FilterButtons from './components/FilterButtons'; 

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <main className="container">
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/contact" element={<Contact />} />
          </Routes>
          {/* <FilterButtons /> 
          <Routes>
            <Route path="/" element={<ImageGallery />} /> 
          </Routes> */}
        </main>
        <Footer />
      </div>
    </Router>
  );
}

export default App;
