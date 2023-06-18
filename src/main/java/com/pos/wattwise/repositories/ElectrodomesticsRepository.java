package com.pos.wattwise.repositories;

import com.pos.wattwise.dtos.ElectrodomesticsDTO;
import com.pos.wattwise.models.ElectrodomesticsModel;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ElectrodomesticsRepository {
    private Set<ElectrodomesticsModel> electrodomesticsList;
    public ElectrodomesticsRepository(){
        electrodomesticsList = new HashSet<>();
    }
    public void save(ElectrodomesticsModel electrodomestics) {
        electrodomesticsList.add(electrodomestics);
    }
}
