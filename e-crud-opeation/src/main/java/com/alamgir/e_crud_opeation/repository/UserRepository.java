package com.alamgir.e_crud_opeation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alamgir.e_crud_opeation.entity.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);

    List<User> findByEmail(String email);

    List<User> findByNameAndEmail(String name, String email);

    List<User> findByNameOrEmail(String name, String email);

    @Modifying
    @Query(value = "DELETE FROM user WHERE NAME = ?1", nativeQuery = true)
    int deleteByName(String name);

    // Native SQL: Indexed Parameter
    @Query(value = "SELECT * FROM USER", nativeQuery = true)
    List<User> getUser();

    @Query(value = "SELECT * FROM user WHERE NAME=?1 AND EMAIL=?2", nativeQuery = true)
    List<User> getUserByNameAndEmail(String name, String email);

    // Native SQL: Named Parameter
    @Query(value = "SELECT * FROM USER WHERE EMAIL=:myEmail AND NAME=:myName", nativeQuery = true)
    List<User> getUserByNameAndEmailNamed(@Param("myName") String a, @Param("myEmail") String b);

    // JPQL query
    @Query(value = "SELECT u FROM User u ", nativeQuery = false)
    List<User> getUserJpql();

    @Query(value = "SELECT u FROM User u WHERE u.name=?1 AND u.email=?2", nativeQuery = false)
    List<User> getUserByNameAndEmailJpql(String name, String email);
}
