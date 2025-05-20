package UNIV.volumbit.repository;

import UNIV.volumbit.model.TestResult;
import UNIV.volumbit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    @Query("SELECT tr.resultType, COUNT(tr) FROM TestResult tr GROUP BY tr.resultType")
    List<Object[]> countResultsByType();
    // 특정 사용자(user)의 기존 결과 삭제
    //void deleteByUser(User user);
    Optional<TestResult> findByUser(User user);
}
