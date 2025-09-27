package com.alamgir.f_entity_relationship_mapping.repository.many_to_many;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alamgir.f_entity_relationship_mapping.entity.User3;

public interface UserRepository extends JpaRepository<User3, Integer> {

}