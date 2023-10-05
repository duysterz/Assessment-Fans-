import React from 'react';
import '../App.css';

const Home = () => {
//Placeholder
    const images = [
        { id: 1, url: 'image_url', description: 'Pic' },
      ];
    
  return (
    <div className="home">
      <div className="home-header">
        <h1 className="home-title">SofaSoGood 🏠 Designs</h1>
        <p className="home-tagline">Your Premier Destination for Home Transformation</p>
      </div>
      <h2>Welcome to the SofaSoGood Designs</h2>
      <p>Here you can explore various interior design styles, types, and colors.</p>
      <div className="image-gallery">
        {images.map((image) => (
          <div key={image.id} className="image-item">
            <img src={image.url} alt={image.description} />
            <p>{image.description}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Home;