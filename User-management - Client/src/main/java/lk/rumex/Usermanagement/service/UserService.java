package lk.rumex.Usermanagement.service;

import lk.rumex.Usermanagement.model.UserDTO;
import lk.rumex.Usermanagement.util.ResponseUtil;

import java.util.List;

public interface UserService {
     ResponseUtil getAllUsers();
     ResponseUtil getUserById(int id);
     ResponseUtil addUser(UserDTO user);
     ResponseUtil updateUser(UserDTO user);
     ResponseUtil deleteUser(int id);

}
