package lk.rumex.Usermanagement.controller;

import lk.rumex.Usermanagement.model.UserDTO;
import lk.rumex.Usermanagement.service.UserService;
import lk.rumex.Usermanagement.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseUtil getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseUtil getAllUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseUtil createUser(@ModelAttribute UserDTO user) {
        return userService.addUser(user);
    }

    @PutMapping
    public ResponseUtil updateUser(@RequestBody UserDTO user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseUtil deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);

    }

}
