package com.alamgir.f_entity_relationship_mapping.repository.many_to_many;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alamgir.f_entity_relationship_mapping.entity.Roles;


public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
