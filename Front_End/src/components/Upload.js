import React, { useState } from 'react';
import '../App.css';
import axios from 'axios';

// const Upload = () => {
//   const [file, setFile] = useState(null);
  
//   const handleFileChange = async (e) => {
//     const selectedFile = e.target.files[0];
//     if (selectedFile) {
//       const description = window.prompt("Enter a description for this image:", "Description here...");
//       if (description !== null) { 
//         const formData = new FormData();
//         formData.append('file', selectedFile);
//         formData.append('description', description);

//         try {
//           const response = await axios.post('http://localhost:8080/upload', formData, {
//             headers: { 'Content-Type': 'multipart/form-data' },
//           });
//           console.log('Upload successful:', response.data);
//         } catch (error) {
//           console.error('Upload failed:', error);
//         }
//       }
//     }
//   };

//   return (
//     <div className="upload">
//       <label htmlFor="file-upload" className="custom-file-upload">
//         Upload Image Here (JPG, PNG, JPEG)
//       </label>
//       <div className="file-row">
//         <input id="file-upload" type="file" accept=".jpg,.jpeg,.png" onChange={handleFileChange} />
//       </div>
//     </div>
//   );
// };

// export default Upload;