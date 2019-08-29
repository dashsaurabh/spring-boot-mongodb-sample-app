package com.progressivecoder.springbootmongodbsampleapp.services;

import com.mongodb.MongoException;
import com.progressivecoder.springbootmongodbsampleapp.documents.Vehicle;
import com.progressivecoder.springbootmongodbsampleapp.dto.VehicleCreateDTO;
import com.progressivecoder.springbootmongodbsampleapp.dto.VehicleUpdateDTO;
import com.progressivecoder.springbootmongodbsampleapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle getVehicleById(UUID id) {

        if (vehicleRepository.findById(id).isPresent())
            return vehicleRepository.findById(id).get();
        else
            throw new MongoException("Record not Found");
    }

    @Override
    public Vehicle createVehicle(VehicleCreateDTO vehicleCreateDTO) {
        Vehicle vehicle = new Vehicle(vehicleCreateDTO.getMake(), vehicleCreateDTO.getModel(), vehicleCreateDTO.getRegistrationNumber());

        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(VehicleUpdateDTO vehicleUpdateDTO, UUID id) {
        if (vehicleRepository.findById(id).isPresent()){
            Vehicle existingVehicle = vehicleRepository.findById(id).get();

            existingVehicle.setMake(vehicleUpdateDTO.getMake());
            existingVehicle.setModel(vehicleUpdateDTO.getModel());

            return vehicleRepository.save(existingVehicle);
        }
        else
            throw new MongoException("Record not found");
    }

    @Override
    public Vehicle deleteVehicleById(UUID id) {
        if (vehicleRepository.findById(id).isPresent()){
            Vehicle vehicle = vehicleRepository.findById(id).get();
            vehicleRepository.delete(vehicle);
            return vehicle;
        }
        else
            throw new MongoException("Record not found");
    }
}
