import React, { useEffect, useState } from 'react';
import '../App.css';

const Home = () => {
  const [images, setImages] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/file')
      .then((response) => response.json())
      .then((data) => {
        console.log("Received data:", data);
        setImages(data);
      })
      .catch((error) => console.error('Error fetching images:', error));
  }, []);

  const handleImageClick = (description) => {
    alert(`Description: ${description}`);
  };

  return (
    <div className="home">
      <div className="home-header">
        <h1 className="home-title">SofaSoGood 🏠 Designs</h1>
        <p className="home-tagline">Your Premier Destination for Home Transformation</p>
      </div>
      <h2>Welcome to the SofaSoGood Designs</h2>
      <p>Here you can explore various interior design styles, types, and colors.</p>
      <div className="image-gallery">
        {Array.isArray(images) && images.map((image) => (  
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
