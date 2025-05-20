package UNIV.volumbit.Service;

import UNIV.volumbit.dto.TestResultRequest;
import UNIV.volumbit.model.ResultType;
import UNIV.volumbit.model.TestResult;
import UNIV.volumbit.model.User;
import UNIV.volumbit.repository.TestResultRepository;
import UNIV.volumbit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestResultService {
    private final TestResultRepository testResultRepository;
    private final UserRepository userRepository;

    // 결과 저장
    public void saveResult(TestResultRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TestResult result = new TestResult();
        result.setUser(user);
        result.setResultType(request.getResultType());

        testResultRepository.save(result);
    }

    // 통계 집계
    public Map<ResultType, Long> getResultStatistics() {
        List<Object[]> resultList = testResultRepository.countResultsByType();

        Map<ResultType, Long> resultMap = new HashMap<>();
        for (Object[] row : resultList) {
            ResultType type = (ResultType) row[0];
            Long count = (Long) row[1];
            resultMap.put(type, count);
        }

        return resultMap;
    }

    // 가장 많은 결과
    public ResultType getMostCommonResultType() {
        return getResultStatistics().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // 가장 적은 결과
    public ResultType getLeastCommonResultType() {
        return getResultStatistics().entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
