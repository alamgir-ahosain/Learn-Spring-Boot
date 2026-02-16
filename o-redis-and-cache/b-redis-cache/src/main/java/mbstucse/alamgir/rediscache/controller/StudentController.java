package mbstucse.alamgir.rediscache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import mbstucse.alamgir.rediscache.dto.request.StudentRequest;
import mbstucse.alamgir.rediscache.dto.response.StudentResponse;
import mbstucse.alamgir.rediscache.service.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        StudentResponse response = studentService.createStudent(studentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET BY ID
    @GetMapping("/get/{studentId}")
    public StudentResponse getStudentById(@PathVariable Long studentId) {
        StudentResponse response = studentService.getStudentById(studentId);
        return response;
    }

    // Update BY ID
    @PutMapping("/update/{studentId}")
    public ResponseEntity<StudentResponse> updateStudentById(@RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.updateStudent(request));
    }

    // DELETE BY ID
    @DeleteMapping("/delete/{studentId}")
    public void deleteStudentBy(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }

    // GET ALL
    @GetMapping("/get")
    public ResponseEntity<List<StudentResponse>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    // GET BY NAME
    @GetMapping("/get/name/{name}")
    public ResponseEntity<List<StudentResponse>> getStudentByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.getStudentByName(name));
    }

    // GET BY EMAIL
    @GetMapping("/get/email/{email}")
    public ResponseEntity<StudentResponse> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(studentService.getByEmail(email));

    }
}
