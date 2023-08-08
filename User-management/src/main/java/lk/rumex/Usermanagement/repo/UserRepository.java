package lk.rumex.Usermanagement.repo;

import lk.rumex.Usermanagement.model.User;

import java.util.List;

public interface UserRepository {
     List<User> getAllUsers();
     User getUserById(int id);
     void addUser(User user);
     void updateUser(User user);
     void deleteUser(int id);

}
