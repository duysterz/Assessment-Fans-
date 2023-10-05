// Component for Room Style
const RoomStyle = ({ roomStyles }) => {
    return (
      <div>
        <h2>Room Styles</h2>
        <ul>
          {roomStyles.map((style) => (
            <li key={style.id}>{style.name}</li>
          ))}
        </ul>
      </div>
    );
  };