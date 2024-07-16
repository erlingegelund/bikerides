package dk.eegelund.bikerides.core;

import dk.eegelund.bikerides.model.RideDto;

import java.util.List;

public interface RideService {
    RideDto createRide(RideDto rideDto);
    void deleteRide(Long id);
    List<RideDto> getRides();
    RideDto getRide(Long id);
    RideDto updateRide(Long id, RideDto rideDto);

}
