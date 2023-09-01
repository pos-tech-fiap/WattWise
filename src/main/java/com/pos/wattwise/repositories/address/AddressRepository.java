package com.pos.wattwise.repositories.address;

import com.pos.wattwise.models.address.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

    Page<Address> findByStreetAndNeighborhoodAndCityAndStateAndZipCode(PageRequest pageRequest,
                                                                          String street,
                                                                          String neighborhood,
                                                                          String city,
                                                                          String state,
                                                                          String zipCode);
}
