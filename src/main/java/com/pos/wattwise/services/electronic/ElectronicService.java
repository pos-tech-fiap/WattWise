package com.pos.wattwise.services.electronic;

import com.pos.wattwise.dtos.electronic.ElectronicDTO;
import com.pos.wattwise.models.address.Address;
import com.pos.wattwise.models.electronic.Electronic;
import com.pos.wattwise.repositories.address.AddressRepository;
import com.pos.wattwise.repositories.electronic.ElectronicRepository;
import com.pos.wattwise.services.exceptions.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ElectronicService {

    @Autowired
    private ElectronicRepository electronicRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional(readOnly = true)
    public Page<ElectronicDTO> findAll(PageRequest pageRequest) {
        Page<Electronic> electronics = electronicRepository.findAll(pageRequest);
        return electronics.map(ElectronicDTO::new);
    }

    @Transactional(readOnly = true)
    public ElectronicDTO findById(UUID id) {
        var electronic = electronicRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Electronic not found"));
        return new ElectronicDTO(electronic);
    }

    @Transactional(readOnly = true)
    public ElectronicDTO findByName(String name) {
        var electronic = electronicRepository.findByName(name).orElseThrow(() -> new ControllerNotFoundException("Electronic not found"));
        return new ElectronicDTO(electronic);
    }

    @Transactional(readOnly = true)
    public ElectronicDTO findByModel(String model) {
        var electronic = electronicRepository.findByModel(model).orElseThrow(() -> new ControllerNotFoundException("Electronic not found"));
        return new ElectronicDTO(electronic);
    }
    @Transactional(readOnly = true)
    public ElectronicDTO findByPower(String power) {
        var electronic = electronicRepository.findByPower(power).orElseThrow(() -> new ControllerNotFoundException("Electronic not found"));
        return new ElectronicDTO(electronic);
    }

    @Transactional
    public ElectronicDTO save(ElectronicDTO personDTO) {
        Electronic electronic = new Electronic();
        mapperDtoToEntity(personDTO, electronic);
        return new ElectronicDTO(electronicRepository.save(electronic));
    }

    @Transactional
    public ElectronicDTO update(UUID id, ElectronicDTO electronicDTO) {
        try {
            Electronic electronic = electronicRepository.getOne(id);
            mapperDtoToEntity(electronicDTO, electronic);
            return new ElectronicDTO(electronicRepository.save(electronic));
        } catch (NoSuchElementException e) {
            throw new ControllerNotFoundException("Electronic not found, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            electronicRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new ControllerNotFoundException("Electronic not found, id: " + id);
        }
    }

    private void mapperDtoToEntity(ElectronicDTO dto, Electronic electronic) {
        electronic.setName(dto.getName());
        electronic.setModel(dto.getModel());
        electronic.setPower(dto.getPower());
        electronic.setAddress(addressRepository.getOne(dto.getAddressId()));
        electronic.setEnergyConsumption(dto.getEnergyConsumption());
    }

    public ElectronicDTO reportUsage(UUID id, double usageTimeInHours) {
        Electronic electronic = electronicRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Electronic not found, id: " + id));

        double energyConsumption = (Double.parseDouble(electronic.getPower()) * usageTimeInHours) / 1000;
        electronic.setEnergyConsumption(energyConsumption);
        return new ElectronicDTO(electronicRepository.save(electronic));
    }
}
