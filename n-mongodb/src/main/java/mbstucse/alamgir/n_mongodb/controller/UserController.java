package mbstucse.alamgir.n_mongodb.controller;

import jakarta.validation.Valid;
import mbstucse.alamgir.n_mongodb.exception.BadRequestException;
import mbstucse.alamgir.n_mongodb.entity.User;
import mbstucse.alamgir.n_mongodb.dto.request.CreateUserRequest;
import mbstucse.alamgir.n_mongodb.exception.NotFoundException;
import mbstucse.alamgir.n_mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("api/create")
    public ResponseEntity<User> createUserHere(@Valid @RequestBody CreateUserRequest request) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }


    @GetMapping("api/read")
    public ResponseEntity<List<User>> readUser() throws BadRequestException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.readUser());
    }



    @GetMapping("api/read/{id}")
    public ResponseEntity<User> readUserById(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.readUserById(id));
    }



    @PutMapping("api/update/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Integer id, @RequestBody CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserById(id, request));
    }

    
    @DeleteMapping("api/delete/{id}")
    public void deleteUerById(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }

}
