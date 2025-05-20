package UNIV.volumbit.Service;

import UNIV.volumbit.dto.UserSignupRequest;
import UNIV.volumbit.model.User;
import UNIV.volumbit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signup(UserSignupRequest request) {
        User user = new User(
                request.getName(),
                request.getPart(),
                request.getUniversity()
        );
        userRepository.save(user);
    }
    //데이터 불러오기 위해 추가한 것.
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
