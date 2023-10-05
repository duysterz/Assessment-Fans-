import React from 'react';

const ImageDetails = ({ image }) => {
  return (
    <div className="image-details">
      <img src={image.url} alt={image.description} />
      <p>{image.description}</p>
    </div>
  );
};

export default ImageDetails;
