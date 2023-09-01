package com.pos.wattwise.repositories.address;

import com.pos.wattwise.models.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

    List<Address> findByStreet(String street);

    List<Address> findByNeighborhood(String neighborhood);

    List<Address> findByCity(String city);

    List<Address> findByState(String state);

    List<Address> findByZipCode(String zipCode);

}
