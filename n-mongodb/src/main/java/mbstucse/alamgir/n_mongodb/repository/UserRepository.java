package mbstucse.alamgir.n_mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import mbstucse.alamgir.n_mongodb.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    boolean existsByEmail(String email);
}
