package lk.rumex.Usermanagement.service;

import lk.rumex.Usermanagement.model.UserDTO;

import java.util.List;

public interface UserService {
     List<UserDTO> getAllUsers();
     UserDTO getUserById(int id);
     void addUser(UserDTO user);
     void updateUser(UserDTO user);
     void deleteUser(int id);

}
