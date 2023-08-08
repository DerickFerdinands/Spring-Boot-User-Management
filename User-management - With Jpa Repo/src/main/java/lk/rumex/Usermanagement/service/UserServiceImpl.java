package lk.rumex.Usermanagement.service;

import lk.rumex.Usermanagement.entity.User;
import lk.rumex.Usermanagement.model.UserDTO;
import lk.rumex.Usermanagement.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        return modelMapper.map(userRepo.findAll(), new TypeToken<List<UserDTO>>(){}.getType());
    }

    @Override
    public UserDTO getUserById(int id) {
        System.out.println(userRepo.findById(id));
        return modelMapper.map(userRepo.findById(id).get(),UserDTO.class);
    }

    @Override
    public void addUser(UserDTO user) {
        System.out.println(modelMapper.map(user, User.class));
    userRepo.save(modelMapper.map(user, User.class));
    }

    @Override
    public void updateUser(UserDTO user) {
        userRepo.save(modelMapper.map(user, User.class));
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }
}
