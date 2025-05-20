package UNIV.volumbit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user") // 매핑될 테이블명
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Part part;

    private String university;

    // 생성자
    public User(String name, Part part, String university) {
        this.name = name;
        this.part = part;
        this.university = university;
    }
}
