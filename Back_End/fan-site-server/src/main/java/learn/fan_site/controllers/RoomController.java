package learn.fan_site.controllers;

import learn.fan_site.domain.RoomService;
import learn.fan_site.domain.Result;
import learn.fan_site.domain.ResultType;
import learn.fan_site.models.Room;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/room")

public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> findAll() {
        return roomService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Room room = roomService.findById(id);
        if (room != null) {
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody @Valid Room room, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return buildInvalidResponse(bindingResult);
        }
        Result<Room> result = roomService.add(room);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id,
                                         @RequestBody @Valid Room room,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return buildInvalidResponse(bindingResult);
        }
        if (id != room.getRoomId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Result<Void> result = roomService.update(room);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else if (result.getResultType() == ResultType.NOT_FOUND) {
            return new ResponseEntity<>(result.getMessages(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id) {
        Result<Void> result = roomService.deleteById(id);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result.getMessages(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Object> buildInvalidResponse(BindingResult bindingResult) {
        return new ResponseEntity<>(bindingResult.getAllErrors().stream()
                .map(i -> i.getDefaultMessage())
                .collect(Collectors.toList()), HttpStatus.BAD_REQUEST);
    }

}
