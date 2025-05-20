package UNIV.volumbit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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

    // 이 결과를 가진 사용자 정보 (User 테이블과 다대일(N:1) 관계)
    // 테스트 결과는 여러 개지만, 한 결과는 하나의 사용자에만 귀속됨
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // ✅ 마지막 결과 저장 시간 (자동 생성)
    @CreationTimestamp
    private LocalDateTime createdAt;
}
