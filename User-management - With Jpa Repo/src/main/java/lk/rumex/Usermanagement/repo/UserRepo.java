package lk.rumex.Usermanagement.repo;

import lk.rumex.Usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
