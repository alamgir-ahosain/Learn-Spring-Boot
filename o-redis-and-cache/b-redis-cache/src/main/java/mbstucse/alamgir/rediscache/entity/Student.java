package mbstucse.alamgir.rediscache.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import mbstucse.alamgir.rediscache.dto.Gender;

@Entity
@Table(name = "students_tbl")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(nullable = false)
    private String name;

    @Email@Column(nullable = false, unique = true)
    private String email;

    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

}
