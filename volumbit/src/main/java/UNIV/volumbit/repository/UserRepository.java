package UNIV.volumbit.repository;

import UNIV.volumbit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
