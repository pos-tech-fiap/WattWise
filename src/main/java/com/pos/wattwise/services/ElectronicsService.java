package com.pos.wattwise.services;

import com.pos.wattwise.dtos.ElectronicsDTO;
import com.pos.wattwise.models.ElectronicsModel;
import com.pos.wattwise.repositories.ElectronicsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ElectronicsService {
    @Autowired
    ElectronicsRepository electronicsRepository;

    public ElectronicsModel save(ElectronicsDTO electronicsDTO){
        var electronicsModel = new ElectronicsModel();
        BeanUtils.copyProperties(electronicsDTO, electronicsModel);
        return electronicsRepository.save(electronicsModel);
    }

    public ElectronicsModel update(ElectronicsDTO electronicsDTO, UUID id){
        return electronicsRepository.update(electronicsDTO, id);
    }

    public Set<ElectronicsModel> findAll(){
        return electronicsRepository.findAll();
    }

    public Optional<ElectronicsModel> findById(UUID id){
        Optional<ElectronicsModel> oneElectronics = electronicsRepository.findById(id);
        return oneElectronics;
    }

    public Boolean removeById(UUID id){
        return electronicsRepository.removeById(id);
    }


}
