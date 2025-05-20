package UNIV.volumbit.dto;

import UNIV.volumbit.model.ResultType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TestResultRequest {
    //사용자가 테스트를 완료했을 때, 그 결과를 백엔드에 전달할 때 사용
    private Long userId;
    private ResultType resultType;
}
