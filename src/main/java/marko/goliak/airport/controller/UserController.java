package marko.goliak.airport.controller;

import marko.goliak.airport.dto.request.UserRequest;
import marko.goliak.airport.dto.response.UserResponse;
import marko.goliak.airport.entity.User;
import marko.goliak.airport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void create(@Valid @RequestBody UserRequest request) {
        userService.save(request);
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    @GetMapping("/byEmail")
    public User findByEmail(String email){
        return userService.findOneByEmail(email);
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody UserRequest request) {
        userService.update(id, request);
    }

    @DeleteMapping
    public void delete(Long id) {
        userService.delete(id);
    }
}