package com.alamgir.f_entity_relationship_mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alamgir.f_entity_relationship_mapping.entity.User1;

public interface UserProfileRepository extends JpaRepository<User1, Integer> {

}
