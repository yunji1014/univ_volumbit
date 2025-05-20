package UNIV.volumbit.dto;

import UNIV.volumbit.model.Part;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotBlank;

@Setter
@Getter
public class UserSignupRequest {
    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    @NotBlank(message = "파트는 필수입니다.")
    private String part;

    @NotBlank(message = "대학교는 필수입니다.")
    private String university;
}
