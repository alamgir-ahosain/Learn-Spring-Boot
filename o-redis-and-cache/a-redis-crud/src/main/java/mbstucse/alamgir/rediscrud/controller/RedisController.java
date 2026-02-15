package mbstucse.alamgir.rediscrud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import mbstucse.alamgir.rediscrud.entity.User;
import mbstucse.alamgir.rediscrud.entity.request.CreateUserRequest;
import mbstucse.alamgir.rediscrud.service.RedisService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class RedisController {


    @Autowired
    private RedisService redisService;

    
    @PostMapping("api/create")
    public User createUser(@RequestBody CreateUserRequest request) {
        return redisService.createUser(request);
    }

    @GetMapping("api/get/{id}")
    public User getUserById(@PathVariable String id) {
        return redisService.getUserById(id);
    }

    @GetMapping("api/get/all")
    public Map<Object, Object> getAllUser() {
        return redisService.getAllUser();
    }

    @GetMapping("api/get/list")
    public List<User> getAll() {
        return redisService.getAll();
    }

    @GetMapping("api/delete/{id}")
    public void deleteUserById(@PathVariable String id) {
        redisService.deleteUserById(id);
    }

}
