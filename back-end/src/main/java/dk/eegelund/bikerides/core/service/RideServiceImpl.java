package dk.eegelund.bikerides.core.service;

import dk.eegelund.bikerides.core.RideService;
import dk.eegelund.bikerides.data.Ride;
import dk.eegelund.bikerides.data.RideRepository;
import dk.eegelund.bikerides.exception.NotFoundException;
import dk.eegelund.bikerides.model.RideDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RideServiceImpl implements RideService {
    private final RideMapper rideMapper;
    private final RideRepository rideRepository;

    @Override
    @Transactional
    public RideDto createRide(RideDto rideDto) {
        final Ride detached = rideMapper.toEntity(rideDto);
        return rideMapper.toDto(rideRepository.save(detached));
    }

    @Override
    @Transactional
    public void deleteRide(Long id) {
        rideRepository.deleteById(id);
    }

    @Override
    public List<RideDto> getRides() {
        return rideRepository.findAll().stream().map(rideMapper::toDto).toList();
    }

    @Override
    public RideDto getRide(Long id) {
        return rideRepository.findById(id).map(rideMapper::toDto).orElseThrow(() -> new NotFoundException("Ride not found"));
    }

    @Override
    @Transactional
    public RideDto updateRide(Long id, RideDto rideDto) {
        final Ride existingRide = rideRepository.findById(id).orElseThrow(() -> new NotFoundException("Ride not found"));
        rideMapper.updateEntity(rideDto, existingRide);
        return rideDto;
    }
}
