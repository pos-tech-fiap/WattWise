package com.pos.wattwise.repositories;

import com.pos.wattwise.models.ElectrodomesticsModel;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Repository
public class ElectrodomesticsRepository  {
    private Set<ElectrodomesticsModel> electrodomesticsList;
    public ElectrodomesticsRepository(){
        electrodomesticsList = new HashSet<>();
    }
    public ElectrodomesticsModel save(ElectrodomesticsModel electrodomestics) {
        electrodomesticsList.add(electrodomestics);
        return electrodomestics;
    }
    public Set<ElectrodomesticsModel> findAll(){
        return electrodomesticsList;
    }
    public Optional<ElectrodomesticsModel> findById(UUID id) {
        return electrodomesticsList.stream().filter(e -> e.getId().equals(id)).findFirst();
    }
}
