package com.progressivecoder.springbootmongodbsampleapp.repositories;

import com.progressivecoder.springbootmongodbsampleapp.documents.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface VehicleRepository extends MongoRepository<Vehicle, UUID> {
}
