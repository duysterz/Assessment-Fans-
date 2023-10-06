import React, { useState } from 'react';

const Upload = () => {
  const [file, setFile] = useState(null);
  const [description, setDescription] = useState('');

  const handleFileChange = (e) => {
    setFile(e.target.files[0]);
  };

  const handleDescriptionChange = (e) => {
    setDescription(e.target.value);
  };

  const handleSubmit = async () => {
    const formData = new FormData();
    formData.append('image', file);
    formData.append('description', description);

    const requestOptions = {
      method: 'POST',
      body: formData
    };

    try {
      const response = await fetch('http://localhost:8080/api/upload', requestOptions);
      if (response.ok) {
        console.log('File and description submitted');
      } else {
        console.log('Upload failed');
      }
    } catch (error) {
      console.log('An error occurred:', error);
    }
  };

  return (
    <div className="upload">
      <input type="file" onChange={handleFileChange} />
      {file && (
        <>
          <textarea placeholder="Enter description" onChange={handleDescriptionChange}></textarea>
          <button onClick={handleSubmit}>Upload</button>
        </>
      )}
    </div>
  );
};

export default Upload;
