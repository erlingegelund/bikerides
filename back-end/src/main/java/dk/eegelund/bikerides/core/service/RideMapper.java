package dk.eegelund.bikerides.core.service;

import dk.eegelund.bikerides.data.ModelRepository;
import dk.eegelund.bikerides.data.Ride;
import dk.eegelund.bikerides.model.RideDto;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
@Mapper
public abstract class RideMapper {
    @Autowired
    protected ModelRepository modelRepository;
    @Mapping(target = "model", expression = "java(modelRepository.findById(rideDto.getModelId()).orElse(null))")
    abstract Ride toEntity(RideDto rideDto);
    @Mapping(target = "modelId", source = "model.id")
    abstract RideDto toDto(Ride rideDto);
    @Mapping(target = "model", expression = "java(modelRepository.findById(rideDto.getModelId()).orElse(null))")
    abstract void updateEntity(RideDto rideDto, @MappingTarget Ride ride);
}
