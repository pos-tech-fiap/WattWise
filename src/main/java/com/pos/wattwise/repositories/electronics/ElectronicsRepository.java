package com.pos.wattwise.repositories.electronics;

import com.pos.wattwise.dtos.electronics.ElectronicsDTO;
import com.pos.wattwise.models.electronics.ElectronicsModel;
import com.pos.wattwise.repositories.exception.RepositoryException;
import com.pos.wattwise.services.address.exceptions.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ElectronicsRepository {
    @Autowired
    private IProdutoRepository repo;

    public Page<ElectronicsModel> findAll(PageRequest pagina) {
        try {
            var electronics = repo.findAll(pagina);
            return electronics.map(prod -> new ElectronicsModel(prod));
        } catch (Exception e) {
            throw new RepositoryException("Failed to get all data !", e);
        }
    }

    public ElectronicsModel save(ElectronicsModel electronicsModel) {
        try {
            repo.save(electronicsModel);
            return electronicsModel;
        } catch (Exception e) {
            throw new RepositoryException("Failed to save data !", e);
        }
    }

    public ElectronicsModel findById(UUID id) {
        var electronic = repo.findById(id).orElseThrow(() -> new RepositoryException("Failed to get data by id!", null));
        return new ElectronicsModel(electronic);
    }

    public void removeById(UUID id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Entity not found with ID: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Base integrity violation");
        }
    }

    public ElectronicsModel update(ElectronicsDTO electronicsDTO, UUID id) {
        try {
            ElectronicsModel electronic = repo.getOne(id);
            electronic.setName(electronicsDTO.name());
            electronic.setModel(electronicsDTO.model());
            electronic.setPower(electronicsDTO.power());
            electronic = repo.save(electronic);

            return new ElectronicsModel(electronic);
        } catch (Exception e) {
            throw new RepositoryException("Failed to save data !", e);
        }
    }
}
