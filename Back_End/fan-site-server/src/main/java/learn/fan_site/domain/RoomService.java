package learn.fan_site.domain;

import learn.fan_site.data.RoomRepository;
import learn.fan_site.models.Room;
import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.List;


@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final Validator validator;

    public RoomService(RoomRepository roomRepository, Validator validator) {
        this.roomRepository = roomRepository;
        this.validator = validator;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room findById(int roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    public Result<Room> add(Room room) {
        Result<Room> result = validate(room);
        if (!result.isSuccess()) {
            return result;
        }

        room = roomRepository.save(room);
        result.setPayload(room);
        return result;
    }

    public Result<Void> update(Room room) {
        Result<Void> result = validate(room);
        if (!result.isSuccess()) {
            return result;
        }
        if (findById(room.getRoomId()) != null) {
            roomRepository.save(room);
            return result;
        }
        result.addMessage(String.format("Room id: '%s' not found.", room.getRoomId()), ResultType.NOT_FOUND);
        return result;
    }

    public Result<Void> deleteById(int roomId) {
        Result<Void> result = new Result<>();
        if (findById(roomId) != null) {
            roomRepository.deleteById(roomId);
            return result;
        }
        result.addMessage(String.format("Room id: '%s' not found.", roomId), ResultType.NOT_FOUND);
        return result;
    }

    private <T> Result<T> validate(Room room) {
        Result<T> result = new Result<>();

        if (room == null) {
            result.addMessage("Room cannot be null.", ResultType.INVALID);
            return result;
        }

        var violations = validator.validate(room);
        for (ConstraintViolation<Room> violation : violations) {
            result.addMessage(violation.getMessage(), ResultType.INVALID);
        }

        return result;
    }
}