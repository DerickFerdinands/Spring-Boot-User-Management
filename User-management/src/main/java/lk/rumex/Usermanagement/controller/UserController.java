package lk.rumex.Usermanagement.controller;

import lk.rumex.Usermanagement.model.User;
import lk.rumex.Usermanagement.repo.JdbcUserRepository;
import lk.rumex.Usermanagement.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private JdbcUserRepository jdbcUserRepository;

    @GetMapping()
    public ResponseUtil getAllUsers() {
        return new ResponseUtil("200", jdbcUserRepository.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseUtil getAllUser(@PathVariable int id) {
        return new ResponseUtil("200", jdbcUserRepository.getUserById(id));
    }

    @PostMapping
    public ResponseUtil createUser(@ModelAttribute User user) {
        jdbcUserRepository.addUser(user);
        return new ResponseUtil("200", "success");
    }

    @PutMapping
    public ResponseUtil updateUser(@RequestBody User user) {
        jdbcUserRepository.updateUser(user);
        return new ResponseUtil("200", "success");
    }

    @DeleteMapping("/{id}")
    public ResponseUtil deleteUser(@PathVariable int id) {
        jdbcUserRepository.deleteUser(id);
        return new ResponseUtil("200", null);
    }

}
