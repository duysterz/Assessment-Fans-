import React, { useState } from 'react';
import '../App.css';

const Upload = () => {
  const [file, setFile] = useState(null);
  
  const handleFileChange = (e) => {
    const selectedFile = e.target.files[0];
    if (selectedFile) {
      const description = window.prompt("Enter a description for this image:", "Description here...");
      if (description !== null) { 
        setFile(selectedFile);
        console.log('File and description submitted:', selectedFile, description);
      }
    }
  };

  return (
    <div className="upload">
      <label htmlFor="file-upload" className="custom-file-upload">
        Upload Image Here (JPG, PNG)
      </label>
      <div className="file-row">
        <input id="file-upload" type="file" accept=".jpg,.jpeg,.png" onChange={handleFileChange} />
      </div>
    </div>
  );
};

export default Upload;
