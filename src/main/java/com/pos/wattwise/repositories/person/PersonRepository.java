package com.pos.wattwise.repositories.person;

import com.pos.wattwise.models.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

}
