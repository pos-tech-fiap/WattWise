package com.pos.wattwise.repositories.person;

import com.pos.wattwise.models.person.Kinship;
import com.pos.wattwise.models.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

    List<Person> findByName(String name);

    List<Person> findByGender(String gender);

    List<Person> findByEmail(String email);

    List<Person> findByKinship(Kinship kinship);
}
