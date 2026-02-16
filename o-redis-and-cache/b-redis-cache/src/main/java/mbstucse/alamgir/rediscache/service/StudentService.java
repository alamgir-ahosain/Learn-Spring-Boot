package mbstucse.alamgir.rediscache.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import mbstucse.alamgir.rediscache.dto.request.StudentRequest;
import mbstucse.alamgir.rediscache.dto.response.StudentResponse;
import mbstucse.alamgir.rediscache.entity.Student;
import mbstucse.alamgir.rediscache.exception.BadRequestException;
import mbstucse.alamgir.rediscache.exception.NotFoundException;
import mbstucse.alamgir.rediscache.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    
    private StudentResponse mapToResponse(Student s) {
        return new StudentResponse(s.getId(), s.getName(), s.getEmail(), s.getGender());
    }


    @CachePut(value = "STUDENT_CACHE", key = "#result.id")
    public StudentResponse createStudent(StudentRequest studentRequest) {

        boolean existsByEmail = studentRepository.existsByEmail(studentRequest.getEmail());
        if (existsByEmail)   throw new BadRequestException("Email : " + studentRequest.getEmail() + " is already taken");

        Student newStudent = new Student();
        newStudent.setName(studentRequest.getName());
        newStudent.setEmail(studentRequest.getEmail());
        newStudent.setGender(studentRequest.getGender());

        Student saved = studentRepository.save(newStudent);
        return mapToResponse(saved);
    }

    
    
    @Cacheable(value = "STUDENT_CACHE", key = "#studentId")
    public StudentResponse getStudentById(Long studentId) {

        System.out.println(" Calling Database for ID: " + studentId);
        Optional<Student> optional = studentRepository.findById(studentId);
        if (!optional.isPresent()) { throw new NotFoundException("Cannot find Student with id " + studentId);  }

        Student student = optional.get();
        return mapToResponse(student);
    }




    @CachePut(value = "STUDENT_CACHE", key = "#result.id")
    public StudentResponse updateStudent(StudentRequest request) {

        Student student = studentRepository.findByEmail(request.getEmail()).orElseThrow(() -> new NotFoundException("Cannot find Student with Email " + request.getEmail()));

        student.setName(request.getName());
        student.setGender(request.getGender());

        Student updatedStudent = studentRepository.save(student);
        return mapToResponse(updatedStudent);
    }




    @CacheEvict(value = "STUDENT_CACHE", key = "#studentId")
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }



    public StudentResponse getByEmail(String email) {

        Student student = studentRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Cannot find Student with email " + email));
        return getStudentById(student.getId());   // call the ID-based method to ensure it gets cached by ID
    }




    public List<StudentResponse> getAllStudent() {
        return studentRepository.findAll()
                .stream()
                .map(student -> new StudentResponse(student.getId(), student.getName(), student.getEmail(),student.getGender()))
                .toList();
    }



    public List<StudentResponse> getStudentByName(String name) {

        List<Student> students = studentRepository.findByName(name);
        if (students.isEmpty()) {throw new NotFoundException("No students found with name: " + name);}
        return students
            .stream()
            .map(student -> new StudentResponse(student.getId(),student.getName(),student.getEmail(),student.getGender()))
            .toList();
    }

}
