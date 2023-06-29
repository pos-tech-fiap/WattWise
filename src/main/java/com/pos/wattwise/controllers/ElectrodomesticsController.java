package com.pos.wattwise.controllers;

import com.pos.wattwise.dtos.ElectrodomesticsDTO;
import com.pos.wattwise.models.ElectrodomesticsModel;
import com.pos.wattwise.repositories.ElectrodomesticsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/electrodomestics")
public class ElectrodomesticsController {

    @Autowired
    ElectrodomesticsRepository electrodomesticsRepository;


    @PostMapping
    public ResponseEntity<ElectrodomesticsModel> saveProduct (@RequestBody @Valid ElectrodomesticsDTO electrodomesticsDTO){
        var electrodomestics = new ElectrodomesticsModel();
        BeanUtils.copyProperties(electrodomesticsDTO, electrodomestics);
        ElectrodomesticsModel saved = electrodomesticsRepository.save(electrodomestics);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity <Set<ElectrodomesticsModel>> getAllElectrodomestics(){
        var electrodomestics = electrodomesticsRepository.findAll();
        return ResponseEntity.ok(electrodomestics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ElectrodomesticsModel>> getById(@RequestBody @Valid @PathVariable UUID id){
        var electrodomestics = electrodomesticsRepository.findById(id);
        return ResponseEntity.ok(electrodomestics);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<ElectrodomesticsModel>> update(@PathVariable UUID id,
                                                                  @RequestBody @Valid ElectrodomesticsDTO eletrodomesticsDTO){
        Optional<ElectrodomesticsModel> electrodomestics0 = electrodomesticsRepository.findById(id);
        var eletrodomestics = electrodomestics0.get();
        BeanUtils.copyProperties(eletrodomesticsDTO, eletrodomestics);
        return ResponseEntity.ok().body(Optional.ofNullable(electrodomesticsRepository.save(eletrodomestics)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        electrodomesticsRepository.delete(id);
        return ResponseEntity.ok().body("Electrodomestic sucessfully deleted!");
    }
}
