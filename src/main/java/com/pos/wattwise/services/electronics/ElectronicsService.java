package com.pos.wattwise.services.electronics;

import com.pos.wattwise.dtos.electronics.ElectronicsDTO;
import com.pos.wattwise.models.electronics.ElectronicsModel;
import com.pos.wattwise.repositories.electronics.ElectronicsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ElectronicsService {
    @Autowired
    ElectronicsRepository electronicsRepository;

    public ElectronicsModel save(ElectronicsDTO electronicsDTO) {
        var electronicsModel = new ElectronicsModel();
        BeanUtils.copyProperties(electronicsDTO, electronicsModel);
        return electronicsRepository.save(electronicsModel);
    }

    public ElectronicsModel update(ElectronicsDTO electronicsDTO, UUID id) {
        return electronicsRepository.update(electronicsDTO, id);
    }

    public Set<ElectronicsModel> findAll(PageRequest pageRequest) {
        return electronicsRepository.findAll(pageRequest).toSet();
    }

    public Optional<ElectronicsModel> findById(UUID id) {
        Optional<ElectronicsModel> oneElectronics = Optional.ofNullable(electronicsRepository.findById(id));
        return oneElectronics;
    }

    public void removeById(UUID id) {
        electronicsRepository.removeById(id);
    }


}
