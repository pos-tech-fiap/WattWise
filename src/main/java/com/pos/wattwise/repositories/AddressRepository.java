package com.pos.wattwise.repositories;

import com.pos.wattwise.models.Address;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class AddressRepository {

    private Set<Address> addressRepository;
}
