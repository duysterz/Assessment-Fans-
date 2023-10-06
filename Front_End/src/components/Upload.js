import React, { useState } from 'react';
import '../App.css';

const Upload = () => {
  const [file, setFile] = useState(null);
  const [description, setDescription] = useState('');

  const handleFileChange = (e) => {
    const selectedFile = e.target.files[0];
    if (selectedFile) {
      setFile(selectedFile);
    }
  };

  const handleDescriptionChange = (e) => {
    setDescription(e.target.value);
  };

  const handleSubmit = () => {
    console.log('File and description submitted:', file, description);
  };

  return (
    <div className="upload">
      <label className="custom-file-upload">
        Upload Your Image Here (File Types: JPG, PNG, JPEG)
      </label>
      <div className="file-row">
        <input id="file-upload" type="file" accept=".jpg,.jpeg,.png" onChange={handleFileChange} />
      </div>
      {file && (
        <div>
          <textarea placeholder="Enter description" onChange={handleDescriptionChange}></textarea>
          <button onClick={handleSubmit}>Upload</button>
        </div>
      )}
    </div>
  );
};

export default Upload;
