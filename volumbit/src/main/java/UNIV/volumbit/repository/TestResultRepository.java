package UNIV.volumbit.repository;

import UNIV.volumbit.model.TestResult;
import UNIV.volumbit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    @Query("SELECT tr.resultType, COUNT(tr) FROM TestResult tr GROUP BY tr.resultType")
    List<Object[]> countResultsByType();
}
