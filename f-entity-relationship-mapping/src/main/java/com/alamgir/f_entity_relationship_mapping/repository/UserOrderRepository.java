package com.alamgir.f_entity_relationship_mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alamgir.f_entity_relationship_mapping.entity.User2;

public interface UserOrderRepository extends JpaRepository<User2, Integer> {

}
