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
    const formData = new FormData();
    formData.append("file", file);
    formData.append("description", description);

    fetch("http://localhost:8080/api/file", {  
      method: "POST",
      body: formData,
    })
    .then(response => response.json())
    .then(data => {
      console.log("File and description uploaded successfully:", data);
    })
    .catch((error) => {
      console.error("Error uploading file and description:", error);
    });
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
