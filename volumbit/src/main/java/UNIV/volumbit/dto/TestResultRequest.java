package UNIV.volumbit.dto;

import UNIV.volumbit.model.ResultType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TestResultRequest {
    private Long userId;
    private ResultType resultType;
}
