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
        return new ResponseUtil("200", userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseUtil getAllUser(@PathVariable int id) {
        return new ResponseUtil("200", userService.getUserById(id));
    }

    @PostMapping
    public ResponseUtil createUser(@ModelAttribute UserDTO user) {
        System.out.println("User" + user);
        userService.addUser(user);
        return new ResponseUtil("200", "success");
    }

    @PutMapping
    public ResponseUtil updateUser(@RequestBody UserDTO user) {
        userService.updateUser(user);
        return new ResponseUtil("200", "success");
    }

    @DeleteMapping("/{id}")
    public ResponseUtil deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseUtil("200", null);
    }

}
