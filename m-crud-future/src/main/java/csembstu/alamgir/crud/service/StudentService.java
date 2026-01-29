package csembstu.alamgir.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csembstu.alamgir.crud.entity.Student;
import csembstu.alamgir.crud.exception.BadRequestException;
import csembstu.alamgir.crud.repository.StudentRepository;
import csembstu.alamgir.crud.request.StudentRequest;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentRequest createStudent(StudentRequest studentRequest) {
        boolean existsByEmail = studentRepository.existsByEmail(studentRequest.getEmail());
        if (existsByEmail) throw new BadRequestException("Email : " + studentRequest.getEmail() + " is already taken");

        Student newStudent = new Student();
        newStudent.setName(studentRequest.getName());
        newStudent.setEmail(studentRequest.getEmail());
        newStudent.setGender(studentRequest.getGender());

        studentRepository.save(newStudent);
        return studentRequest;
    }

}
