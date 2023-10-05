import React from 'react';

const ImageGallery = ({ images }) => {
  return (
    <div className="image-gallery">
      {images.map((image, index) => (
        <div key={index} className="image-item">
          <img src={image.url} alt={image.description} />
        </div>
        //not sure how the API come in here
      ))}
    </div>
  );
};

export default ImageGallery;
