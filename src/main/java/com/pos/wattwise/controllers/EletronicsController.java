package com.pos.wattwise.controllers;

import com.pos.wattwise.dtos.ElectronicsDTO;
import com.pos.wattwise.models.ElectronicsModel;
import com.pos.wattwise.repositories.EletronicsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EletronicsController {
    @Autowired
    EletronicsRepository eletronicsRepository;

    @PostMapping("/eletronic")
    public ResponseEntity<ElectronicsModel> create(@RequestBody @Valid ElectronicsDTO electronicsDTO){
        var eletronicsModel = new ElectronicsModel();
        BeanUtils.copyProperties(electronicsDTO, eletronicsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(eletronicsRepository.save(eletronicsModel));
    }

}
