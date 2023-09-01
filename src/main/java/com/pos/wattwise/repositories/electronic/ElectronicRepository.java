package com.pos.wattwise.repositories.electronic;

import com.pos.wattwise.models.electronic.Electronic;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ElectronicRepository extends JpaRepository<Electronic, UUID> {
    Optional<Electronic> findByName(String name);
    Optional<Electronic> findByModel(String model);
    Optional<Electronic> findByPower(String power);

}
