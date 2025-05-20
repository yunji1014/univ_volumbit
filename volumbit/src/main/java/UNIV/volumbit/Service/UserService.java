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

    // 사용자 회원가입 처리
    public void signup(UserSignupRequest request) {
        // DTO에서 값을 꺼내 User 엔티티 생성
        User user = new User(
                request.getName(),
                request.getPart(),
                request.getUniversity()
        );
        userRepository.save(user);
    }
    // 모든 사용자 정보를 조회 (Read)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
