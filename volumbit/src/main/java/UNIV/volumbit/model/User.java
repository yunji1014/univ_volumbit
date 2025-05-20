package UNIV.volumbit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String part;

    private String university;

    public User(String name, String part, String university) {
        this.name = name;
        this.part = part;
        this.university = university;
    }
}
