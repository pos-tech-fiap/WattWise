package com.pos.wattwise.repositories.electronics;

import com.pos.wattwise.dtos.electronics.ElectronicsDTO;
import com.pos.wattwise.models.electronics.ElectronicsModel;
import com.pos.wattwise.repositories.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public class ElectronicsRepository {
   private Set<ElectronicsModel> electronicsRepository;

    public ElectronicsRepository() { electronicsRepository = new HashSet<>(); }

    public ElectronicsModel save(ElectronicsModel electronicsModel){
        try {
            electronicsRepository.add(electronicsModel);
            return electronicsModel;
        } catch (Exception e) {
            throw new RepositoryException("Failed to save data !", e);
        }
    }

    public Set<ElectronicsModel> findAll() {
        try{
            return electronicsRepository;
        } catch (Exception e) {
            throw new RepositoryException("Failed to get all data !", e);
        }
    }

    public Optional<ElectronicsModel> findById(UUID id) {
        try{
            return electronicsRepository.stream()
                    .filter(electronics -> electronics.findOne(id))
                    .findFirst();
        } catch (Exception e) {
            throw new RepositoryException("Failed to get data by id!", e);
        }
    }

    public boolean removeById(UUID id) {
        try{
            ElectronicsModel electronic = this.findById(id).orElse(null);
            if(electronic != null){
                electronicsRepository.remove(electronic);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RepositoryException("Failed to update data !", e);
        }
    }

    public ElectronicsModel update(ElectronicsDTO electronicsDTO, UUID id) {
        try {
            ElectronicsModel electronic = this.findById(id).orElse(null);
            electronic.setName(electronicsDTO.name());
            electronic.setModel(electronicsDTO.model());
            electronic.setPower(electronicsDTO.power());

            return electronic;
        } catch (Exception e) {
            throw new RepositoryException("Failed to save data !", e);
        }
    }
}
