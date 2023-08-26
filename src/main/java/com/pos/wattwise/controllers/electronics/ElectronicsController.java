package com.pos.wattwise.controllers.electronics;

import com.pos.wattwise.dtos.electronics.ElectronicsDTO;
import com.pos.wattwise.models.electronics.ElectronicsModel;
import com.pos.wattwise.services.electronics.ElectronicsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    ElectronicsService electronicsService;

    @PostMapping("/electronic")
    public ResponseEntity<ElectronicsModel> create(@RequestBody @Valid ElectronicsDTO electronicsDTO){
        var response = electronicsService.save(electronicsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/electronic/{id}")
    public ResponseEntity<ElectronicsModel> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid ElectronicsDTO electronicsDTO){
        return ResponseEntity.status(HttpStatus.OK).body(electronicsService.update(electronicsDTO, id));
    }
    @GetMapping("/electronic")
    public ResponseEntity<Set<ElectronicsModel>> getAll(){
        var pagina = 0;
        var tamanho = 10;
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        var produtos = electronicsService.findAll(pageRequest);
        return ResponseEntity.ok(produtos);

    }
    @GetMapping("/electronic/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") UUID id){
        Optional<ElectronicsModel> oneElectronics = electronicsService.findById(id);
        if (oneElectronics.isEmpty()) {
            return ResponseEntity.badRequest().body("Electronic device not found on this system");
        }
        return ResponseEntity.ok(oneElectronics);
    }
    @DeleteMapping("/electronic/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") UUID id){
        electronicsService.removeById(id);
        return ResponseEntity.noContent().build();
    }

}
