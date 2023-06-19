package com.pos.wattwise.controllers;

import com.pos.wattwise.dtos.ElectronicsDTO;
import com.pos.wattwise.models.ElectronicsModel;
import com.pos.wattwise.repositories.ElectronicsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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
        Set<ElectronicsModel> allElectronics = electronicsRepository.findAll();
        if (allElectronics.isEmpty()) {
            return ResponseEntity.badRequest().body(new HashSet<>());
        }
        return ResponseEntity.ok(allElectronics);

    }
    @GetMapping("/electronic/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") UUID id){
        Optional<ElectronicsModel> oneElectronics = electronicsRepository.findById(id);
        if (oneElectronics.isEmpty()) {
            return ResponseEntity.badRequest().body("Electronic device not found on this system");
        }
        return ResponseEntity.ok(oneElectronics);
    }

}
