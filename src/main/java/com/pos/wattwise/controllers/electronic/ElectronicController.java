package com.pos.wattwise.controllers.electronic;

import com.pos.wattwise.dtos.electronic.ElectronicDTO;
import com.pos.wattwise.services.electronic.ElectronicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/electronics")
public class ElectronicController {
    
    @Autowired
    ElectronicService electronicService;

    @GetMapping
    public ResponseEntity<Page<ElectronicDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok().body(electronicService.findAll(pageRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ElectronicDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(electronicService.findById(id));
    }

    @GetMapping(value = "/{name}/name")
    public ResponseEntity<ElectronicDTO> findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(electronicService.findByName(name));
    }

    @GetMapping(value = "/{model}/model")
    public ResponseEntity<ElectronicDTO> findByModel(@PathVariable String model) {
        return ResponseEntity.ok().body(electronicService.findByModel(model));
    }
    @GetMapping(value = "/{power}/power")
    public ResponseEntity<ElectronicDTO> findByPower(@PathVariable String power) {
        return ResponseEntity.ok().body(electronicService.findByPower(power));
    }

    @PostMapping
    public ResponseEntity<ElectronicDTO> save(@RequestBody @Valid ElectronicDTO personDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(electronicService.save(personDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ElectronicDTO> update(@PathVariable UUID id, @RequestBody @Valid ElectronicDTO personDTO) {
        return ResponseEntity.ok().body(electronicService.update(id, personDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        electronicService.delete(id);
        return ResponseEntity.ok().body("Electronic deleted successfully!");
    }
    @PutMapping(value = "/{id}/report-usage")
    public ResponseEntity<ElectronicDTO> reportUsage (
            @PathVariable UUID id,
            @RequestParam double usageTimeInHours
    ){
        ElectronicDTO electronicDTO = electronicService.reportUsage(id, usageTimeInHours);
        return ResponseEntity.ok().body(electronicDTO);
    }
}
