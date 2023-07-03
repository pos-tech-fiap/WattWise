package com.pos.wattwise.services;

import com.pos.wattwise.controllers.ElectronicsController;
import com.pos.wattwise.dtos.ElectronicsDTO;
import com.pos.wattwise.models.ElectronicsModel;
import com.pos.wattwise.repositories.ElectronicsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ElectronicsServiceTest {
    @InjectMocks
    private ElectronicsService service;

    @Mock
    private ElectronicsRepository repository;

    @Test
    public void ShouldReturnSuccessWhenFundId(){
        ElectronicsModel electronic = new ElectronicsModel();
        electronic.setName("TV");
        electronic.setModel("LG");
        electronic.setPower("220");

        Mockito.when(repository.findById((UUID) ArgumentMatchers.any())).thenReturn(Optional.of(electronic));
        Optional<ElectronicsModel> electronicsModel = service.findById(electronic.getId());

        assertNotNull(electronicsModel);

    }

}
