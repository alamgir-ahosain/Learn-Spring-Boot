package mbstucse.alamgir.rediscache.repository;

import java.util.List;
import java.util.Optional;

import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mbstucse.alamgir.rediscache.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);

    List<Student> findByName(String name);

    Optional<Student> findByEmail(@Email String email);
}