package mbstucse.alamgir.rediscrud.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import mbstucse.alamgir.rediscrud.entity.User;
import mbstucse.alamgir.rediscrud.entity.request.CreateUserRequest;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "USER";

    // Create User
    public User createUser(CreateUserRequest request) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        redisTemplate.opsForHash().put(KEY, user.getId(), user);
        return user;
    }



    // Get User By id
    public User getUserById(String id) {
        return (User) redisTemplate.opsForHash().get(KEY, id);
    }



    // Delete User By Id
    public void deleteUserById(String id) {
        redisTemplate.opsForHash().delete(KEY, id);
    }



    // Get All User
    public Map<Object, Object> getAllUser() {
        return redisTemplate.opsForHash().entries(KEY);
    }


    
    //Get All User as List
    public List<User> getAll() {

        Map<Object, Object> all = redisTemplate.opsForHash().entries(KEY);
        Collection<Object> values = all.values();
        List<User> collecList = values.stream().map(value -> (User) value).collect(Collectors.toList());
        return collecList;
    }

}
