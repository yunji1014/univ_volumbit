package UNIV.volumbit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "test_result")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ResultType resultType; // 추천된 봉사활동 파트

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
