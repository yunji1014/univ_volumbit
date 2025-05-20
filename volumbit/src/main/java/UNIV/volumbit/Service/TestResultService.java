package UNIV.volumbit.Service;

import UNIV.volumbit.dto.TestResultRequest;
import UNIV.volumbit.model.ResultType;
import UNIV.volumbit.model.TestResult;
import UNIV.volumbit.model.User;
import UNIV.volumbit.repository.TestResultRepository;
import UNIV.volumbit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TestResultService {
    private final TestResultRepository testResultRepository;
    private final UserRepository userRepository;

    // ✅ 결과 저장 (기존 결과 삭제 후 새로 저장)
    @Transactional
    public void saveResult(TestResultRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        /* delete 후 create연산
        // ✅ 이전 결과 삭제
        testResultRepository.deleteByUser(user);

        // ✅ 새 결과 저장
        TestResult result = new TestResult();
        result.setUser(user);
        result.setResultType(request.getResultType());

        testResultRepository.save(result);
         */

        //update연산 이용 단, delete는 사용x..
        // 기존 결과 조회 (update를 사용하여.. 결과 수정.)
        Optional<TestResult> existingResult = testResultRepository.findByUser(user);

        if (existingResult.isPresent()) {
            // ✅ 결과 수정
            TestResult result = existingResult.get();
            result.setResultType(request.getResultType());
            // createdAt은 수정 안 함 (기존값 유지)
            testResultRepository.save(result); // UPDATE
        } else {
            // ✅ 새로 저장
            TestResult result = new TestResult();
            result.setUser(user);
            result.setResultType(request.getResultType());
            testResultRepository.save(result); // INSERT
        }
    }

    // 통계 집계
    public Map<ResultType, Long> getResultStatistics() {
        List<Object[]> resultList = testResultRepository.countResultsByType();

        // 1. 초기화: 모든 ResultType을 0으로 설정
        Map<ResultType, Long> resultMap = new EnumMap<>(ResultType.class);
        for (ResultType type : ResultType.values()) {
            resultMap.put(type, 0L);
        }

        // 2. 실제 값으로 덮어쓰기
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
