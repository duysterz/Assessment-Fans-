import React, { useState } from 'react';
import RoomType from './components/RoomType';
import RoomStyle from './components/RoomStyle';
import Rooms from './components/Rooms';


const App = () => {
  const [roomTypes, setRoomTypes] = useState([]);
  const [roomStyles, setRoomStyles] = useState([]);
  const [rooms, setRooms] = useState([]);

  useEffect(() => {
    // Fetch Room Types
    fetch('/room-types')
      .then((res) => res.json())
      .then((data) => setRoomTypes(data));

    // Fetch Room Styles
    fetch('/room-styles')
      .then((res) => res.json())
      .then((data) => setRoomStyles(data));

    // Fetch Rooms
    fetch('/rooms')
      .then((res) => res.json())
      .then((data) => setRooms(data));
  }, []);

  return (
    <div>
      <h1>Interior Design Fan Page</h1>
      <RoomType roomTypes={roomTypes} />
      <RoomStyle roomStyles={roomStyles} />
      <Rooms rooms={rooms} roomTypes={roomTypes} roomStyles={roomStyles} />
    </div>
  );
};

export default App;




