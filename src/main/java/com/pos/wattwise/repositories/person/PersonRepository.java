package com.pos.wattwise.repositories.person;

import com.pos.wattwise.dtos.person.PersonDTO;
import com.pos.wattwise.models.person.Person;

import com.pos.wattwise.repositories.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public class PersonRepository {

    private Set<Person> personRepository;

    public PersonRepository() {
        personRepository = new HashSet<>();
    }

    public Person save(Person person){
        personRepository.add(person);
        return person;
    }

    public Person update(UUID id, PersonDTO personDTO) {
        try {
            Person person = this.findById(id).orElse(null);
            person.setName(personDTO.getName());
            person.setGender(personDTO.getGender());
            person.setBirthDate(personDTO.getBirthDate());
            person.setEmail(personDTO.getEmail());
            person.setPhone(personDTO.getPhone());
            person.setKinship(personDTO.getKinship());

            return person;
        } catch (Exception exception) {
            throw new RepositoryException("Erro ao atualizar pessoa", exception);
        }
    }

    public boolean delete(UUID id) {
        try{
            Person person = this.findById(id).orElse(null);
            if (person != null) {
                personRepository.remove(person);
                return true;
            }
            return false;
        } catch (Exception exception) {
            throw new RepositoryException("Erro ao remover pessoa", exception);
        }
    }

    public Optional<Person> findById(UUID id) {
        try{
            return personRepository.stream()
                    .filter(person -> person.getId().equals(id))
                    .findFirst();
        } catch (Exception exception) {
            throw new RepositoryException("Erro ao buscar pessoa por id", exception);
        }
    }

    public Set<Person> findAll() {
        try{
            return personRepository;
        } catch (Exception exception) {
            throw new RepositoryException("Erro ao buscar todas as pessoas", exception);
        }
    }
}
