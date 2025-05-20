package UNIV.volumbit.dto;

import UNIV.volumbit.model.Part;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotBlank;

@Setter
@Getter
public class UserSignupRequest {
    //dto파일.. Spring Boot 백엔드에서 클라이언트(프론트엔드 또는 Postman)
    // 로부터 받는 데이터의 "형태와 구조"를 정의
    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    @NotBlank(message = "파트는 필수입니다.")
    private Part part;
    //NotBlank: 유효성 검사를 자동으로 처리
    @NotBlank(message = "대학교는 필수입니다.")
    private String university;
}
