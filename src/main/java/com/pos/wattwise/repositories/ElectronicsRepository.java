package com.pos.wattwise.repositories;

import com.pos.wattwise.models.ElectronicsModel;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ElectronicsRepository {
   private Set<ElectronicsModel> electronicsRepository;

    public ElectronicsRepository() { electronicsRepository = new HashSet<>(); }

    public ElectronicsModel save(ElectronicsModel electronicsModel){
        electronicsRepository.add(electronicsModel);
        return electronicsModel;
    }

    public Set<ElectronicsModel> getALl() {
        return electronicsRepository;
    }
}
