package UNIV.volumbit.controller;

import UNIV.volumbit.Service.TestResultService;
import UNIV.volumbit.dto.TestResultRequest;
import UNIV.volumbit.dto.TestResultResponse;
import UNIV.volumbit.model.ResultType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test-result")
public class TestResultController {
    private final TestResultService testResultService;

    @PostMapping
    public ResponseEntity<String> submitResult(@RequestBody TestResultRequest request) {
        testResultService.saveResult(request);
        return ResponseEntity.ok("결과가 저장되었습니다.");
    }

    @GetMapping("/statistics")
    public ResponseEntity<Map<ResultType, Long>> getStatistics() {
        return ResponseEntity.ok(testResultService.getResultStatistics());
    }

    @GetMapping("/most")
    public ResponseEntity<ResultType> getMostCommon() {
        return ResponseEntity.ok(testResultService.getMostCommonResultType());
    }

    @GetMapping("/least")
    public ResponseEntity<ResultType> getLeastCommon() {
        return ResponseEntity.ok(testResultService.getLeastCommonResultType());
    }
}