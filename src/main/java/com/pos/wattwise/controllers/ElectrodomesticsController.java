package com.pos.wattwise.controllers;

import com.pos.wattwise.dtos.ElectrodomesticsDTO;
import com.pos.wattwise.models.ElectrodomesticsModel;
import com.pos.wattwise.repositories.ElectrodomesticsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/electrodomestics")
public class ElectrodomesticsController {

    @Autowired
    private ElectrodomesticsRepository electrodomesticsRepository;


    @PostMapping
    public ResponseEntity<ElectrodomesticsModel> saveProduct (@RequestBody @Valid ElectrodomesticsDTO electrodomesticsDTO){
        var electrodomestics = new ElectrodomesticsModel();
        BeanUtils.copyProperties(electrodomesticsDTO, electrodomestics);
        electrodomesticsRepository.save(electrodomestics);
        return ResponseEntity.status(HttpStatus.CREATED).body(electrodomestics);
    }

}
