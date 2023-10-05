import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
// import ImageGallery from './components/ImageGallery'; 
// import FilterButtons from './components/FilterButtons'; 

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <main className="container">
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
