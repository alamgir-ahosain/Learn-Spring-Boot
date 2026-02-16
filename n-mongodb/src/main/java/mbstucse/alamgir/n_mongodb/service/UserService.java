package mbstucse.alamgir.n_mongodb.service;

import mbstucse.alamgir.n_mongodb.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mbstucse.alamgir.n_mongodb.dto.request.CreateUserRequest;
import mbstucse.alamgir.n_mongodb.entity.User;
import mbstucse.alamgir.n_mongodb.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;




    public User createUser(CreateUserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {  throw new RuntimeException("Email already exists");  }

        User user = new User();
        user.setId(request.getId());
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setEmail(request.getEmail());

        return userRepository.save(user);
    }





    public List<User> readUser() {
        List<User> users=userRepository.findAll();
        return users;
    }





    public User readUserById(int id) {
       Optional<User> optionalUser= userRepository.findById(id);

       if (!optionalUser.isPresent())  throw new NotFoundException("Id "+id+" is not Exist");
        User user=optionalUser.get();
        return  user;
    }




    public void deleteUserById(int id) {
        Optional<User> check=userRepository.findById(id);

        if (check.isPresent()) userRepository.deleteById(id);
        else throw new NotFoundException("Id "+id+" is not Exist");
    }

    public User updateUserById(int id,CreateUserRequest request) {

        Optional<User> check=userRepository.findById(id);

        if (!check.isPresent()) throw new NotFoundException("Id "+id+" is not Exist");

        User user=new User();
        user.setId(request.getId());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setAge(request.getAge());

       User savedUser= userRepository.save(user);
       return  savedUser;
    }
}
