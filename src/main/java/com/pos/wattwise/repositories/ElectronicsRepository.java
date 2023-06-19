package com.pos.wattwise.repositories;

import com.pos.wattwise.dtos.ElectronicsDTO;
import com.pos.wattwise.models.ElectronicsModel;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public class ElectronicsRepository {
   private Set<ElectronicsModel> electronicsRepository;

    public ElectronicsRepository() { electronicsRepository = new HashSet<>(); }

    public ElectronicsModel save(ElectronicsModel electronicsModel){
        electronicsRepository.add(electronicsModel);
        return electronicsModel;
    }

    public Set<ElectronicsModel> findAll() {
        return electronicsRepository;
    }

    public Optional<ElectronicsModel> findById(UUID id) {
        return electronicsRepository.stream()
                .filter(electronics -> electronics.findOne(id))
                .findFirst();
    }

    public boolean removeById(UUID id) {
        ElectronicsModel electronic = this.findById(id).orElse(null);
        if(electronic != null){
            electronicsRepository.remove(electronic);
            return true;
        }
        return false;
    }

    public ElectronicsModel update(ElectronicsDTO electronicsDTO, UUID id) {
        ElectronicsModel electronic = this.findById(id).orElse(null);

        electronic.setName(electronicsDTO.name());
        electronic.setModel(electronicsDTO.model());
        electronic.setPower(electronicsDTO.power());

        return electronic;
    }
}
