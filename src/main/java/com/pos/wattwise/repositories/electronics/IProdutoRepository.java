package com.pos.wattwise.repositories.electronics;

import com.pos.wattwise.models.electronics.ElectronicsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProdutoRepository extends JpaRepository<ElectronicsModel, UUID> {}