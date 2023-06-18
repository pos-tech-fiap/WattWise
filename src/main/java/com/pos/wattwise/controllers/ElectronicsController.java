package com.pos.wattwise.controllers;

import com.pos.wattwise.dtos.ElectronicsDTO;
import com.pos.wattwise.models.ElectronicsModel;
import com.pos.wattwise.repositories.ElectronicsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class ElectronicsController {
    @Autowired
    ElectronicsRepository electronicsRepository;

    @PostMapping("/electronic")
    public ResponseEntity<ElectronicsModel> create(@RequestBody @Valid ElectronicsDTO electronicsDTO){
        var electronicsModel = new ElectronicsModel();
        BeanUtils.copyProperties(electronicsDTO, electronicsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(electronicsRepository.save(electronicsModel));
    }

    @GetMapping("/electronic")
    public ResponseEntity<Set<ElectronicsModel>> getAll(){
        Set<ElectronicsModel> allElectronics = electronicsRepository.getALl();
        if (allElectronics.isEmpty()) {
            return ResponseEntity.badRequest().body(new HashSet<>());
        }
        return ResponseEntity.ok(allElectronics);

    }

}
