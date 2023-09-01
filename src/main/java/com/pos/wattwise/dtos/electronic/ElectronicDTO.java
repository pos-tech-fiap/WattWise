package com.pos.wattwise.dtos.electronic;

import com.pos.wattwise.models.electronic.Electronic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ElectronicDTO {

    private UUID id;

    @NotBlank(message = "Name field is required!")
    private String name;

    @NotBlank(message = "Model field is required!")
    private String model;

    @NotBlank(message = "Power field is required!")
    private String power;

    @NotNull
    private UUID addressId;
    private double energyConsumption;

    public ElectronicDTO() {
    }

    public ElectronicDTO(UUID id, String name, String model, String power, UUID addressId, double energyConsumption) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.power = power;
        this.addressId = addressId;
        this.energyConsumption = energyConsumption;
    }

    public ElectronicDTO(Electronic electronic) {
        this.id = electronic.getId();
        this.name = electronic.getName();
        this.model = electronic.getModel();
        this.power = electronic.getPower();
        this.addressId = electronic.getAddress().getId();
        this.energyConsumption = electronic.getEnergyConsumption();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    public double getEnergyConsumption() { return energyConsumption; }

    public void setEnergyConsumption(double energyConsumption) {this.energyConsumption = energyConsumption; }
}
