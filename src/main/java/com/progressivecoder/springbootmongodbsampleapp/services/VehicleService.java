package com.progressivecoder.springbootmongodbsampleapp.services;

import com.progressivecoder.springbootmongodbsampleapp.documents.Vehicle;
import com.progressivecoder.springbootmongodbsampleapp.dto.VehicleCreateDTO;
import com.progressivecoder.springbootmongodbsampleapp.dto.VehicleUpdateDTO;

import java.util.UUID;

public interface VehicleService {

    public Vehicle getVehicleById(UUID id);
    public Vehicle createVehicle(VehicleCreateDTO vehicleCreateDTO);
    public Vehicle updateVehicle(VehicleUpdateDTO vehicleUpdateDTO, UUID id);
    public Vehicle deleteVehicleById(UUID id);
}
