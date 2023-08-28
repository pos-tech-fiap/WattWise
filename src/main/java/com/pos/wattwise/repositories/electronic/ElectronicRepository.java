package com.pos.wattwise.repositories.electronic;

import com.pos.wattwise.models.electronic.Electronic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ElectronicRepository extends JpaRepository<Electronic, UUID> {

}
